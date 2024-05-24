package org.example.homework6.user;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_SUPPORT;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
