package com.dongdong.spring.test.testPackage;

/**
 * @Description:
 * @Date: 2019/11/21  15:54
 * @Author: dongdong
 */
public class ClassModifier {
    /**Class 文件 中常量池的起始偏移 */
    private static final int  CONSTANT_POOL_COUNT_INDEX=8;

    private static final  int CONSTANT_UTF_8_info=1;

    /** 常量池中11种常量占用的长度*/
    private static final int[] CONSTANT_ITME_LENGTH={-1,-1,-1,5,5,9,9,3,3,5,5,5,5};

    private static final int u1=1;
    private static final int u2=1;
    private byte[] classByte;

    public ClassModifier(byte[] classByte){
        this.classByte=classByte;
    }

    /**
     * 修改常量池中CONSTANT_UTF8_info
     * @param newStr
     * @param oldStr
     * @return 修改结果
     * */

    public byte[] modifyUTF8Constant(String oldStr,String newStr){
       int cpc=getConstantPoolCountIndex();
       int offset=CONSTANT_POOL_COUNT_INDEX+u2;
       for(int i=0;i<cpc;i++){
           int tag=ByteUtils.bytes2Int(classByte,offset,u1);
           if(tag==CONSTANT_UTF_8_info) {
               int len  =ByteUtils.bytes2Int(classByte,offset+u1,u2);
               offset += (u1 + u2);
               String str = ByteUtils.bytes2String(classByte, offset,len);
               if(str.equalsIgnoreCase(oldStr)){
                   byte[] strBytes=ByteUtils.string2Bytes(newStr);
                   byte[] strLen=ByteUtils.int2Bytes(newStr.length(),u2);
                   classByte=ByteUtils.bytesReplace(classByte,offset-u2,u2,strLen);
                   classByte=ByteUtils.bytesReplace(classByte,offset,len,strBytes);
                   return classByte;
               }else{
                   offset+=len;
               }
           }else {
               offset+=CONSTANT_ITME_LENGTH[tag];
           }

       }

        return classByte;
    }


    /**
     * 获取常量池中的数量
     *
     *
     * */

    public int getConstantPoolCountIndex(){
        return ByteUtils.bytes2Int(classByte,CONSTANT_POOL_COUNT_INDEX,u2);
    }

}
