package md.weatherAdventure.config.security.jwt;

import md.weatherAdventure.entity.RoleEntity;
import md.weatherAdventure.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final  class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(UserEntity user) {
        List<RoleEntity> list = new ArrayList();
        list.add(user.getRoleEntity());
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getUserDetailEntityId().getFam(),
                user.getUserDetailEntityId().getIm(),
                user.getUserDetailEntityId().getOt(),
                user.getPassword(),
                mapToGrantedAuthorities(list),
                true

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleEntity> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority("ROLE_"+role.getCode().getAuthority())
                ).collect(Collectors.toList());
    }
}
