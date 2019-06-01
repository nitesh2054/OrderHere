package com.nitesh.orderhere.security;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFascade {
    Authentication getAuthentication();
}
