package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 *最小编辑代价
 */
public class Class13_MinEditCost {

    public static  int getMinCost1(String str1,String str2,int ic,int dc,int rc){
        if(str1==null || str2==null){
            return 0;
        }
        char[] chars1=str1.toCharArray();
        char[] chars2=str2.toCharArray();
        int row=str1.length()+1;
        int col=str2.length()+1;
        int[][] dp=new int[row][col];
        for(int i=1;i<row;i++){
            dp[i][0]=i*dc;
        }
        for(int j=1;j<col;j++){
            dp[0][j]=j*ic;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i-1][j-1]+rc;
                }
               dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+dc);
               dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+ic);
            }
        }
        return dp[row-1][col-1];
    }

    public static void main(String[] args) {
        String str1="abc";
        String str2="adc";
        System.out.println(getMinCost1(str1,str2,5,3,2));
    }
}
