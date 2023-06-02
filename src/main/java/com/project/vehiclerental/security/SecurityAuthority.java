package com.project.vehiclerental.security;

import com.project.vehiclerental.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

    private final transient Authority authority;


    public String getAuthority() {
        return authority.getName();
    }
}
