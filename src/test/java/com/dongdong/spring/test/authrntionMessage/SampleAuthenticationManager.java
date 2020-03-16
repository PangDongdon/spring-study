package com.dongdong.spring.test.authrntionMessage;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Date: 2019/11/27  9:45
 * @Author: dongdong
 */
public class SampleAuthenticationManager implements  AuthenticationManager {

    static{

    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication.getName().equals(authentication.getCredentials())){
            List<GrantedAuthority> authorities=new ArrayList<>();
            return new UsernamePasswordAuthenticationToken(authentication.getName(),authentication.getCredentials(),authorities);
        }
        throw  new BadCredentialsException("bad Credentials");
    }
}
