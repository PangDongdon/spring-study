package com.dongdong.spring.test.leetCode.stack;

import net.dongliu.commons.Sys;
import org.junit.Test;

import java.net.InetAddress;
import java.util.*;

/**
 * @Description:  简化路径
 * @Date: 2020/12/17  11:01
 * @Author: dongdong
 */
public class Sort71 {

    public  String simplifyPath(String path){
        Deque<String> stack=new LinkedList<>();
        Set<String> skipSet= new HashSet<>(Arrays.asList("..",".",""));
        for(String dir: path.split("/")){
            if(dir.equals("..") && !stack.isEmpty()){//   "/a/./b/../../c/"
                stack.pop();
            }else if(!skipSet.contains(dir)){//a b .. .. c
                stack.push(dir);
            }
        }
        String result="";
        for(String dir:stack){
            result="/"+dir+"";
        }
        return  result.isEmpty()?"/":result;
    }

    @Test
    public  void test(){
        System.out.println(simplifyPath("/a/./b/../../c/"));
    }
}
