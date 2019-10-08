package com.dongdong.spring.service;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/9/29  10:35
 */
public class Redis {

    public  static  void main(String args[]){
        //指定redis 相关的服务器名称与端口号
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("dongdong","is number one");
        System.out.println("redis cache number is"+jedis.get("dongdong"));
    }




}
