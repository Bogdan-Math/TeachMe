package ua.teachme.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    COMMON,
    EXPANDED,
    ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
