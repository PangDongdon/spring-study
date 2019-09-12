package com.dongdong.spring.service;

import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Description:
 *
 * @Auther: dongdong
 * @Date: 2019/9/11  14:20
 */
@Service
public class DemoService {

    @Retryable(value={Exception.class},maxAttempts = 3)
    public void call() throws Exception{
      System.out.println("do everything is possible");
      throw  new Exception("PRC调用异常");
    }
    @Recover
    public void recover (RemoteAccessException e){
        System.out.println(e.getMessage());
    }



}
