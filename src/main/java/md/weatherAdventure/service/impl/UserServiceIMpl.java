package md.weatherAdventure.service.impl;

import md.weatherAdventure.dto.UserDto;
import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.repository.UserDetailRepository;
import md.weatherAdventure.repository.UserRepository;
import md.weatherAdventure.service.ModelMapperService;
import md.weatherAdventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceIMpl implements UserService {
    UserRepository userRepository;
    UserDetailRepository userDetailRepository;
    ModelMapperService<UserDto, UserEntity> mapperService;

    @Autowired
    @Qualifier("user")
    public void setMapperService(ModelMapperService<UserDto, UserEntity> mapperService) {
        this.mapperService = mapperService;
    }

    @Autowired
    public void setUserDetailRepository(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public UserEntity findById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    @Transactional
    public UserDto save(UserDto dto) {
        UserEntity userEntity = mapperService.dtoToEntity(dto);
        userDetailRepository.saveAndFlush(userEntity.getUserDetailEntityId());
        userRepository.saveAndFlush(userEntity);
        return mapperService.entityToDto(userEntity);
    }
}
