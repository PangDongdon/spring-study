package com.dongdong.spring.test.alBook.unit05String;

/**
 * 字符串的统计字符串
 */
public class Class04_StatisticsStr {

    public static String getCountString(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }

        char[] chars = str.toCharArray();
        String res = String.valueOf(chars[0]);
        int num = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                res = connect(res, String.valueOf(num), String.valueOf(chars[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return connect(res, String.valueOf(num), "");
    }

    public static String connect(String str1, String str2, String str3) {
        return str1 + "_" + str2 + (str3.equals("") ? str3 : "_" + str3);
    }

    public static char getCharAt(String cstr, int index) {
        if (cstr == null || cstr.equals("")) {
            return 0;
        }
        char[] chs = cstr.toCharArray();
        boolean stage = true;
        char cur = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != chs.length; i++) {
            if (chs[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return cur;
                }
                num = 0;
                cur = chs[i];
            } else {
                num = num * 10 + chs[i] - '0';
            }
        }
        return num + num > index ? cur : 0;
    }

    public static void main(String[] args) {
        String str = "aaabbadddffc";
        System.out.println(getCountString(str));
        String str2="a_3_b_2_a_1_d_3_f_2_c_1";
        System.out.println(getCharAt(str2, 2));
    }
}
