package com.dongdong.spring.test.aspect;

import com.dongdong.spring.ApplicationTests;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Description:
 * @Date: 2020/8/6  11:55
 * @Author: dongdong
 */
@Aspect
public class AspectTest1  extends ApplicationTests {

    @Pointcut(value = "execution(* com.dongdong.spring.test.*.*.*(..))")
    public void point(){

    }

    @Before(value = "point()")
    public void before(){
        System.out.println("transaction begin");
    }


    @AfterReturning(value = "point()")
    public void after(){
        System.out.println("transaction commit");
    }

    @Around(value = "point()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("transaction begin");
        proceedingJoinPoint.proceed();
        System.out.println("transaction commit");
    }

    public static void main(String[] args) {
        System.out.println("running");
    }
}
