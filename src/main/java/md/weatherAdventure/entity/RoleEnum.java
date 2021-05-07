package md.weatherAdventure.entity;

import org.springframework.security.core.GrantedAuthority;

public enum RoleEnum implements GrantedAuthority {

    CLIENT,

    MODERATOR,
    ADMIN,
    ALL;

    @Override
    public String getAuthority() {
        return name();
    }
}
