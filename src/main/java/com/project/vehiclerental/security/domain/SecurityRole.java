package com.project.vehiclerental.security.domain;

import com.project.vehiclerental.entity.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityRole implements GrantedAuthority {

    private final transient Role role;

    public String getAuthority() {
        return role.getName();
    }
}
