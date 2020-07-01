package com.dongdong.spring.test.threadPool;

import lombok.Data;
import net.dongliu.commons.Sys;

/**
 * @Description:
 * @Date: 2020/7/1  10:21
 * @Author: dongdong
 */
@Data
public class Worker implements  Runnable {
    //任务编号
    private String id;

    public Worker(String id){
        this.id=id;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(id+"正常执行");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
