package md.weatherAdventure.service.impl;

import md.weatherAdventure.config.security.jwt.JwtTokenProvider;
import md.weatherAdventure.dto.AuthenticationAnswerDto;
import md.weatherAdventure.dto.AuthenticationRequestDto;
import md.weatherAdventure.dto.UserDto;
import md.weatherAdventure.entity.RoleEntity;
import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.repository.RoleRepository;
import md.weatherAdventure.repository.UserDetailRepository;
import md.weatherAdventure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorizationServicempl {
    private PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserDetailRepository userDetailReposotiry;
    RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;


    @Autowired
    public AuthorizationServicempl(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserDetailReposotiry(UserDetailRepository userDetailReposotiry) {
        this.userDetailReposotiry = userDetailReposotiry;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    public UserEntity loadByUserNam(String userName) {
        return userRepository.findByLogin(userName);
    }


    public AuthenticationAnswerDto authorization(AuthenticationRequestDto requestDto) {
        String username = requestDto.getUsername();
        UserEntity user = loadByUserNam(requestDto.getUsername());
        if (user == null) {
            return new AuthenticationAnswerDto("Пользователь с таким логином не найден");
        }
        if (user.getActive() == null || !user.getActive()) {
            return new AuthenticationAnswerDto("Пользователь заблокирован");
        }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestDto.getUsername(), requestDto.getPassword()));

        List<RoleEntity> role = new ArrayList<>();
        role.add(user.getRoleEntity());
        String token = jwtTokenProvider.createToken(username, role);

        return new AuthenticationAnswerDto(username, token, user.getUserDetailEntityId().getFam() + " " + user.getUserDetailEntityId().getIm() + " " + user.getUserDetailEntityId().getOt(), user.getRoleEntity().getName(), user.getRoleEntity().getCode().toString());
    }


}
