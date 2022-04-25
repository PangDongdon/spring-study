package com.dongdong.spring.test.sort3.test.unit06;

public class ArtistProblem {

    public static int solution(int[] arr,int m){
        if(arr==null || arr.length==0 | m<1){
            return 0;
        }
        if(arr.length<m){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<arr.length;i++){
                max=Math.max(max,arr[i]);
            }
            return max;
        }else{
            int max=0;
            int min=0;
            for (int i = 0; i < arr.length; i++) {
                max += arr[i];
            }
            while(min!=max-1) {
                int mid = (min + max) / 2;
                if (getNeedNum(arr, mid) > m) {
                    min = mid;
                } else {
                    max = mid;
                }
            }
            return max;
        }
    }

    private static int getNeedNum(int[] arr, int limit) {
        int res=1;
        int value=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>limit){
                return  Integer.MAX_VALUE;
            }
            value+=arr[i];
            if(value>limit){
                res++;
                value=arr[i];
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        int[] arr={3,1,4};
        System.out.println(solution(arr,2));
    }
}
