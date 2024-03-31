package com.dongdong.spring.test.sort2;

public class Test {

    public int test(int[] arr ,int L,int R){
        int r=arr[R];
        int a=L-1;
        for(int i=L;i<R;i++){
            if(arr[i]<=r){
                JavaUtil.swapNum(arr,++a,i);
            }
        }
        return  a;
    }

    //public static  int[] s={5,2,6,7,8,88,9,0};
    @org.junit.Test
    public void test2(){
        System.out.println(partiotion(JavaUtil.s,0,JavaUtil.s.length-1)[0]);
    }

    public  int[] partiotion(int[] arr,int L,int R){
        int less=L-1;
        int more=R;
        while(L<more){
            if(arr[L]<arr[R]){
                JavaUtil.swapNum(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                JavaUtil.swapNum(arr,--more,L);
            }else{
                L++;
            }
        }
        JavaUtil.swapNum(arr,more,R);
        return  new int[]{less+1,more};
    }
}
