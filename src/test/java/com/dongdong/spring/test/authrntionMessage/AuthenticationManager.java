package com.dongdong.spring.test.authrntionMessage;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * @Description:
 * @Date: 2019/11/27  9:16
 * @Author: dongdong
 */
public interface AuthenticationManager {
     Authentication  authenticate(Authentication authentication) throws AuthenticationException;
}
