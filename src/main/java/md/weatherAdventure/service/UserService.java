package md.weatherAdventure.service;

import md.weatherAdventure.dto.UserDto;
import md.weatherAdventure.entity.UserEntity;

public interface UserService {
    UserEntity findByUsername(String username);
    UserEntity findById(Long id);
    UserDto save (UserDto dto);
}
