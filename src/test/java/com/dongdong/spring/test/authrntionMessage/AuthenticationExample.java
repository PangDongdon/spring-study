package com.dongdong.spring.test.authrntionMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @Description:
 * @Date: 2019/11/27  9:55
 * @Author: dongdong
 */

public class AuthenticationExample {
    private static Log log= LogFactory.getLog(AuthenticationExample.class);
    private static AuthenticationManager am=new SampleAuthenticationManager();
    public static void main(String[] args) throws IOException {
        long time=System.currentTimeMillis();
        log.info("代码开始执行,执行时间="+time);
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Please enter your username");
            String name=in.readLine();
            System.out.println("Please entry your password");
            String password=in.readLine();

        try{
            Authentication request=new UsernamePasswordAuthenticationToken(name,password);
            Authentication result=am.authenticate(request);
            SecurityContextHolder .getContext().setAuthentication(result);
            break;
        }catch(AuthenticationException  e){
            System.out.println("Authentication failed "+e.getMessage());
            e.printStackTrace();
        }
        }
        log.info("代码执行完成,执行耗时="+(System.currentTimeMillis()-time)+"ms");
        System.out.println("Successfully authenticated.Security context contains"+SecurityContextHolder.getContext().getAuthentication());
    }


}
