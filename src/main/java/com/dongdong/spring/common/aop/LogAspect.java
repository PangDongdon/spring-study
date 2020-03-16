package com.dongdong.spring.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description:
 * @Date: 2019/11/28  9:49
 * @Author: dongdong
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.dongdong.spring.api.*.*(..))")
    public void loginLog(){

    }
    @Before("loginLog()")
    public void loginBefore(JoinPoint joinPoint){
      //从请求上下文中获得requet,获得请求内容
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest  request=attributes.getRequest();
        System.out.println("请求路径："+request.getRequestURL());
        System.out.println("请求方式："+request.getMethod());
        System.out.println("方法名："+joinPoint.getSignature().getName());
        System.out.println("类路径："+joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("参数："+ Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "object",pointcut = "loginLog()")
    public void doAfterReurning(Object object){
       System.out.println("方法返回值："+object);
    }

    @AfterThrowing(throwing = "e",pointcut = "loginLog()")
    public void throwExcute(JoinPoint joinPoint,Exception e){
           System.out.println("方法执行异常："+e.getMessage());
    }

    @After("loginLog()")
    public void afterInform(){
      System.out.println("后置通知结束");
    }

    @Around("loginLog()")
    public Object surroundInform(ProceedingJoinPoint joinPoint){
        System.out.println("环绕执行开始");
        try{
            Object o=joinPoint.proceed();
            System.out.println("环绕执行结束");
            return  o;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
