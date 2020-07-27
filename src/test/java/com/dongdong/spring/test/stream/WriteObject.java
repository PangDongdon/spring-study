package com.dongdong.spring.test.stream;

import java.io.*;

/**
 * @Description:
 * @Date: 2020/7/16  13:58
 * @Author: dongdong
 */
public class WriteObject {
    public static void main(String[] args) {
        try{
            /******序列化******/
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(new File("D:\\test.txt")));
            Person p=new Person("dd","20");
            objectOutputStream.writeObject(p);
            /******反序列化******/
             ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("D:\\test.txt"));
             Person pp= (Person)objectInputStream.readObject();
             System.out.println(pp.getAge()+"::"+pp.getName());
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
