package com.dongdong.spring.test.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Date: 2020/7/15  15:09
 * @Author: dongdong
 */
public class ReadFromProcess {
    public static void main(String[] args)  throws IOException {
        Process p=Runtime.getRuntime().exec("javac");
        try(BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()));){
         String buff=null;

         while((buff=br.readLine())!=null){
             System.out.println(buff);
         }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
