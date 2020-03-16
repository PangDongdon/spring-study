package com.dongdong.spring.test.testPackage;

import org.junit.Test;

/**
 * @Description: byte 数组处理工具
 * @Date: 2019/11/21  16:16
 * @Author: dongdong
 */
public class ByteUtils {

    public static  int bytes2Int(byte[] b,int start,int len){
        int sum=0;
        int end =start+len;
        for(int i=start;i<len;i++) {
            int n = ((int) b[i]) & 0xff;
            n <<= (--len) * 8;
            sum = n + sum;
        }
        return sum;
    }

    public static byte[]  int2Bytes(int value,int len){
        byte[] b=new byte[len];
        for(int i=0;i<len;i++){
            b[len-i-1]=(byte)((value>>8*i)& 0xff);
        }
        return  b;
    }

    public static String bytes2String(byte[] b,int start,int len){
        return new String(b,start,len);
    }

    public static byte[] string2Bytes(String str){
        return str.getBytes();
    }

    @Test
    public void test(){
        byte[] b={'1','c','d','d'};
        System.out.println(bytes2String(b,0,3));
    }

    public static byte[] bytesReplace(byte[] originalBytes,int offset,int len,byte[] replaceBytes){
        byte[] newBytes=new byte[originalBytes.length+(replaceBytes.length-len)];
        System.arraycopy(originalBytes,0,newBytes,0,offset);
        System.arraycopy(replaceBytes,0,newBytes,offset,replaceBytes.length);
        System.arraycopy(originalBytes,offset+len,newBytes,offset+replaceBytes.length,originalBytes.length-offset-len);
        return newBytes;
    }


}
