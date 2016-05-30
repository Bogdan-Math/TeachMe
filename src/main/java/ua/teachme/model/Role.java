package ua.teachme.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ANONYMOUS,
    COMMON,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
