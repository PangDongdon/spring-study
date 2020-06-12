package com.dongdong.spring.test.testPackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Date: 2020/5/7  17:22
 * @Author: dongdong
 */
public class RuntimeTest {
    public static void main(String[] args) throws IOException {
      /*  //获取Java程序关联的运行时对象
        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.availableProcessors()+","+runtime.freeMemory()+","+runtime.totalMemory()+","+runtime.maxMemory());
        //直接启动进程来运行操作系统的命令
        runtime.exec("\"C:\\Program Files (x86)\\KuGou\\KGMusic\\KuGou.exe\"");*/
    //  System.out.println("dd".getBytes());
     // System.out.println(new Random().nextInt(10));
       /* System.out.println(new Random().nextDouble());
        System.out.println(new BigDecimal(0.05).add(new BigDecimal(0.01)));
        System.out.println(BigDecimal.valueOf(0.05).add(BigDecimal.valueOf(0.01)));*/
       // Calendar calendar=Calendar.getInstance();
       //  System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
       // String str="hello,java!";
       // System.out.println(str.replaceFirst("\\w*","fff"));
       // System.out.println(str.replaceFirst("\\w*?","fff"));
      /*  Pattern  pattern=Pattern.compile("a*b");
        Matcher matcher1= pattern.matcher("aaaaaab");
        System.out.println(matcher1.find());*/
        String str="我想要java书籍，若有请联系我13222245554"
                   +"出售二手电脑，联系我18323224567";
        Matcher  matcher=Pattern.compile("\\d{11}").matcher(str);
        if(matcher.find()){
            //打印出电话号码
            System.out.println(matcher.group());

        }

     /*  String regStr="学习Java is very easy!";
       System.out.println("目标字符串为："+regStr);
       Matcher m=Pattern.compile("\\w+").matcher(regStr);
       while(m.find()){
           System.out.println(m.group()+"子串的起始位置："+m.start()+"子串的结束位置："+m.end());
       }*/
        Collection c=new ArrayList();
        c.toString();
    }
}
