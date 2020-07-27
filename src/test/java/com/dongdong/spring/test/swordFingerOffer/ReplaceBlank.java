package com.dongdong.spring.test.swordFingerOffer;

/**
 * @Description: 空格替换
 * @Date: 2020/7/27  17:20
 * @Author: dongdong
 */
public class ReplaceBlank {
    public static String replaceBlank(String input){
        if(input==null){
            return  null;
        }
        StringBuffer buffer=new StringBuffer();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)==' '){
                buffer.append("%");
                buffer.append("2");
                buffer.append("0");
            }else {
                buffer.append(input.charAt(i));
            }
        }
        return new String(buffer);
    }

    public static void main(String[] args) {
        System.out.println(replaceBlank("dong dong"));
    }

}
