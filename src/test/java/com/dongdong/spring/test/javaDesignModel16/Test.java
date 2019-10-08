package com.dongdong.spring.test.javaDesignModel16;

/**
 * @Description:
 * @Auther: dongdong
 * @Date: 2019/10/8  9:50
 */
public class Test {

    public static void main(String[] args){
        List list=new ListImpl();
        list.add("q");
        list.add("dd");
        Iterator  it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("======== second  way  =======");
        for(int i=0;i<list.getSize();i++){
            System.out.println(list.get(i));
        }


    }
}
