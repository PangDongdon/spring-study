package com.dongdong.spring.test.alBook.unit05String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 拼接所有字符串产生字典序最小的大写字符串
 */
public class Class17_AllStrGenerateMinDictSortBigStr {
    public class MyComparator implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }

        public String lowerString(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            //根据新的比较方式排序
            Arrays.sort(strs, new MyComparator());
            String res = "";
            for (int i = 0; i < strs.length; i++) {
                res += strs[i];
            }
            return res;
        }
    }

}
