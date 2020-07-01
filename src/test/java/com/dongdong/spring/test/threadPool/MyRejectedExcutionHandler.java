package com.dongdong.spring.test.threadPool;

import com.dongdong.spring.test.javadDesignModel1.Work;
import net.dongliu.commons.Sys;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description:
 * @Date: 2020/7/1  10:26
 * @Author: dongdong
 */
public class MyRejectedExcutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
          try{
             Worker worker=(Worker) r;
             //模拟日志输出
              System.out.println(worker.getId()+"被丢弃");
              executor.getQueue().put(r);
          }catch(Exception e){
              System.out.println("线程进入饱和策略发生异常：线程信息"+r.toString());
          }
    }
}
