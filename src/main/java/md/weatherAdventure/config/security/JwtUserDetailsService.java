package md.weatherAdventure.config.security;

import md.weatherAdventure.config.security.jwt.JwtUser;
import md.weatherAdventure.config.security.jwt.JwtUserFactory;
import md.weatherAdventure.entity.UserEntity;
import md.weatherAdventure.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
//        log.info("IN loadUserByUsername - user with username: {} successfully loaded", username);
        return jwtUser;
    }

}
