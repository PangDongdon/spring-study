package com.dongdong.spring.test.sort3.test.unit08;

public class KTimesOneTime {

    public static int printOneNum(int[] arr) {
        int m = 0;
        for (int n : arr) {
            m = m ^ n;
        }
        return m;
    }

    public static int[] printTwo(int[] arr) {
        int m1 = 0;
        for (int n : arr) {
            m1 = m1 ^ n;
        }
        //
        int m2 = m1 ^ (~m1 + 1);
        int m3 = 0;
        for (int n : arr) {
            if ((m2 & n) != 0) {
                m3 = m3 ^ n;
            }
        }
        return new int[]{m3, m1 ^ m3};
    }

    public static int printKNum(int[] arr,int k) {
        int[] e0=new int[32];
        for(int i=0;i<arr.length;i++){
            setExclusiveOr(e0,arr[i],k);
        }
        return getNumFromKSysNum(e0,k);
    }

    public static void setExclusiveOr(int[] eO, int value, int k) {
        int[] kSysNumFromNum = getKSysNumFromNum(value, k);
        for(int i=0;i<eO.length;i++){
            eO[i]=(eO[i]+kSysNumFromNum[i])%k;
        }
    }

    public static void main(String[] args) {
       // int[] arr = {1, 2, 2, 3, 4, 3, 4, 1, 8};
       // System.out.println(printOneNum(arr));
      //  int[] arr2 = {1, 2, 2, 3, 4, 3, 4, 8};
      //  printNum(printTwo(arr2));
     getKSysNumFromNum(5,2);
    }

    public static void printNum(int[] arr) {
        for (int n : arr) {
            System.out.println(n);
        }
    }

    //10->K
    public static int[] getKSysNumFromNum(int value, int k) {
        int [] bits=new int[32];
        int index=0;
        while(value>0){
            bits[index++]=value%k;
            value=value/k;
        }
        return bits;
    }

    //k进制转10进制
    public static  int getNumFromKSysNum(int[] eo,int k){
        int res=0;
        for(int i=0;i<eo.length;i++){
            res=res*k+eo[i];
        }
        return  res;
    }
}
