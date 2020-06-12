package com.dongdong.spring.test.collection;

import lombok.Data;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

/**
 * @Description:
 * @Date: 2020/5/21  10:38
 * @Author: dongdong
 */
@Data
public class LinkedHashSetTest {
    private  String name="oook";
    public static void main(String[] args){
        /**LinkedHashSet*/
//        LinkedHashSet<String> ss=new LinkedHashSet<>();
//        ss.add("1");
//        ss.add("2");
//        System.out.println(ss);

//        TreeSet<Integer> treeSet=new TreeSet<>();
//        treeSet.add(3);
//        treeSet.add(1);
//        System.out.println(treeSet);
//        Vector<String> vector=new Vector<>();
//        vector.add("ss");
//        Stack<String> stack=new Stack<>();
//        stack.push("aa");
//        stack.push("bb");
//        System.out.println(stack.pop());
//        ArrayDeque deque=new ArrayDeque();
//        deque.offer("study");
//        deque.offer("hard");
//        System.out.println(deque.poll());

//          LinkedList<String> linkedList=new LinkedList<>();
//          linkedList.offer("dd");
//          linkedList.offer("aa");
//          linkedList.push("work hard");
//          linkedList.push("cc");
//          System.out.println(linkedList.pop());
//          System.out.println(linkedList);

        /*Map<String,String> map=new HashMap<>();
        map.put("1","dd");
        map.put("2","ff");
        System.out.println(map.entrySet());
        Hashtable hashtable=new Hashtable();
        hashtable.put("ff","");*/
//        LinkedHashSetTest ss=null;
//        if(ss==null){
//            System.out.println("ssss");
//        }System.out.println(ss.name);
//        Properties properties=new Properties();
//        properties.setProperty("name","dongdong");
//        properties.setProperty("age","24");
//        properties.store(new FileOutputStream("E:\\dd.ini"),"comment line");
//        Properties properties2=new Properties();
//        properties2.setProperty("sex","man");
//        properties2.load(new FileInputStream("E:\\dd.ini"));
//        System.out.println(properties2);
//        WeakHashMap<String,String> weak=new WeakHashMap<>();
//        weak.put(new String("aa"),"1");
//        weak.put(new String("bb"),"2");
//        weak.put(new String("cc"),"3");
//        System.out.println(weak);
//        weak.put("java","ok");
//        System.out.println(weak);
//        System.gc();
//        System.runFinalization();
//        System.out.println(weak);
//        Collections.synchronizedMap();
//          String[] srArr={"a","b"};
//          List<String> atrArr=new ArrayList<>();
//          fromArrayToCollection(srArr,atrArr);
       // System.out.println(dd("dddd"));testCatch();
//        System.out.println();
//        List<?>[] la=new ArrayList[10];
//        throwRuntime(3);
        try {
            firstMethod();
        }catch(SelfException e){
            e.printStackTrace();
        }
        AnnotationConfigApplicationContext aa=new AnnotationConfigApplicationContext("");
        Object object=  aa.getBean("");
    }

    static void fromArrayToCollection(Object[] a,Collection<Object> c){
        for(Object o:a){
            c.add(o);
        }
    }

    static <T> void sss(T[]a, Collection<T> collection){
        for(T o:a){
            collection.add(o);
        }

    }

    static boolean dd(String ss){
        if(ss.equals("dd")){
            return  true;
        }
        if(ss.equals("dddd") && ss.length()==2 ){
            return  true;
        }
        return  true;
    }

    static int  testCatch(){
        try{
           int i =3/0;
        }catch(Exception e){
            e.printStackTrace();
            return 1;
        }finally {
            System.out.println("执行了");
        }
        return  2;
    }

    public static <T> T copy(Collection<T> dest,Collection<? extends  T> src){
        T last=null;
        for(T ele:src){
            last=ele;
            dest.add(ele);
        }
        return   last;
    }

//    <T> T[] makeArray(Collection<T> coll){
//     //   return  new T[coll.size()];
//    }


    public void  ess(){

        try{

        } catch(RuntimeException e){

        }
    }

    public static void throwRuntime(int a){
        if(a>0){
            throw new RuntimeException("error ,please correct!");
        }
    }

     public static void firstMethod(){
         secondMethod();
     }
    public static void secondMethod(){
        thirdMethod();
    }
    public static void thirdMethod(){
        throw  new SelfException("test trace error message");
    }


    static class SelfException extends  RuntimeException{
        SelfException(){}
        SelfException(String msg){
            super(msg);
        }

    }
}
