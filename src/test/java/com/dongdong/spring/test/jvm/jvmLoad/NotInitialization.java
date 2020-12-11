package com.dongdong.spring.test.jvm.jvmLoad;

/**
 * @Description:
 * @Date: 2020/11/4  14:09
 * @Author: dongdong
 */
public class NotInitialization {

    public static void main(String[] args) {
        /*System.out.println(ConstClass.HELLOEORD);*/
      //  int[] arr=new int[]{1,2,3,4,5,6,7,8,9,0};
        int count=0;
         for(int i=1;i<11;i++){
             System.out.print(i%10);
             count++;
             if(count==1){
                 System.out.println();
             }else if(count==3){
                 System.out.println();
             }else if(count==6) {
                 System.out.println();
             }else  if(count==10){
                 System.out.println();
             }
         }


    }
}
