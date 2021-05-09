package md.weatherAdventure.service.impl.mapper;

import md.weatherAdventure.dto.UserDto;
import md.weatherAdventure.entity.RoleEnum;
import md.weatherAdventure.entity.UserDetailEntity;
import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.UserService;
import md.weatherAdventure.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("userMapper")
public class UserModelMapperServiceImpl   implements ModelMapperService<UserDto, UserEntity> {

    UserService userService;
    RoleServiceImpl roleService;
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }



    @Override
    public UserDto entityToDto(UserEntity entity) {
        UserDto userDto = new UserDto();
        userDto.setId(entity.getId());
        userDto.setFam(entity.getUserDetailEntityId().getFam());
        userDto.setIm(entity.getUserDetailEntityId().getIm());
        userDto.setOt(entity.getUserDetailEntityId().getOt());
        userDto.setLogin(entity.getLogin());
        userDto.setActive(entity.getActive());
        return userDto;
    }

    @Override
    public UserEntity dtoToEntity(UserDto dto) {
        UserEntity userEntity = null;
        if (dto.getId() != null) {
            userService.findById(dto.getId());
        } else {
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setFam(dto.getFam());
            userDetailEntity.setIm(dto.getIm());
            userDetailEntity.setOt(dto.getOt());

            userEntity = new UserEntity();
            userEntity.setLogin(dto.getLogin());
            userEntity.setActive(dto.getActive());
            userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
            userEntity.setRoleEntity(roleService.findByCode(RoleEnum.CLIENT));
            userEntity.setUserDetailEntityId(userDetailEntity);
        }


        return userEntity;
    }

    @Override
    public UserEntity FromMapToEntity(Map map) {
        return null;
    }
}
