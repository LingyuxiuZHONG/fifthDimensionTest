package com.example.fifthdimensiontest.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * AuthenticationProvider 是Spring Security中用于处理身份验证的接口。
 * 它定义了一种标准的身份验证方法，用于验证用户提供的凭据，
 * 并返回一个完整的身份验证对象（Authentication）表示认证成功，或抛出异常表示认证失败
 *
 * 通常情况下，需要重写AuthenticationProvider接口来自定义身份验证逻辑
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = String.valueOf(authentication.getPrincipal());
        String password = String.valueOf(authentication.getCredentials());

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        // matches(CharSequence rawPassword, String encodedPassword)
        if(password.equals(userDetails.getPassword())){
            // 继承自 AbstractAuthenticationToken 类，是 Authentication 接口的一个具体实现。
            return new UsernamePasswordAuthenticationToken(username,password,userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Error!!");
    }

    /**
     * supports() 方法用于指示该身份验证提供者是否支持指定类型的 Authentication 对象
     * @param authentication
     * @return
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
