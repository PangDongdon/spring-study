package com.dongdong.spring.test.sort3.test.unit05;

public class Decompress_String {


    public static String decompress(String decompressStr) {
        char[] chs = decompressStr.toCharArray();
        return process(chs, 0).str;
    }

    public static class ReturnData {
        public String str;
        public int end;

        public ReturnData(String str, int nextIndex) {
            this.str = str;
            this.end = nextIndex;
        }
    }

    public static ReturnData process(char[] chs, int index) {
        if (chs == null) {
            return null;
        }
        int chsLength = chs.length;
        StringBuilder res = new StringBuilder();
        int times = 0;
        while (index < chsLength && chs[index] != '}') {
            if (chs[index] == '{') {
                ReturnData process = process(chs, index+1);
                res.append(getTimesString(times, process.str));
                index = process.end;
                times = 0;
            } else {
                if (chs[index] >= '0' && chs[index] <= '9') {
                    times = times * 10 + Integer.parseInt(String.valueOf(chs[index]));
                }
                if (chs[index] >= 'a' && chs[index] <= 'z') {
                    res.append(String.valueOf(chs[index]));
                }
            }
            index++;
        }
        return new ReturnData(res.toString(), index);
    }


    public static String getTimesString(int times, String base) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            stringBuilder.append(base);
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        String test1 = "3{a}2{bc}";
        String test2 = "3{a2{c}}";
        String test3 = "2{abc}3{cd}ef";
        System.out.println(decompress(test1));
        System.out.println(decompress(test2));
        System.out.println(decompress(test3));
    }
    //aaabcbc
    //accaccacc
    //abcabccdcdcdef
}
