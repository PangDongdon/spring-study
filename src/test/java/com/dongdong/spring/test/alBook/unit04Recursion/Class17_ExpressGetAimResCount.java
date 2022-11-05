package com.dongdong.spring.test.alBook.unit04Recursion;

/**
 * 表达式得到期望结果的组成种数
 */
public class Class17_ExpressGetAimResCount {

    public static boolean isValid(char[] ss) {
        if ((ss.length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < ss.length; i += 2) {
            if (ss[i] != '1' && ss[i] != '0') {
                return false;
            }
        }
        for (int i = 1; i < ss.length; i += 2) {
            if (ss[i] != '|' && ss[i] != '&' && ss[i] != '^') {
                return false;
            }
        }
        return true;
    }

    public static int num1(String exp, boolean desired) {
        if (exp == null || "".equals(exp)) {
            return 0;
        }
        char[] chars = exp.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }
        return process(chars, desired, 0, chars.length - 1);
    }

    private static int process(char[] chars, boolean desired, int l, int r) {
        if (l == r) {
            if (chars[l] == '1') {
                return desired ? 1 : 0;
            } else {
                return desired ? 0 : 1;
            }
        }
        int res = 0;
        if (desired) {
            for (int i = l + 1; i < r; i += 2) {
                switch (chars[i]) {
                    case '&':
                        res += process(chars, true, l, i - 1) * process(chars, true, i + 1, r);
                        break;
                    case '|':
                        res += process(chars, true, l, i - 1) * process(chars, false, i + 1, r);
                        res += process(chars, true, l, i - 1) * process(chars, true, i + 1, r);
                        res += process(chars, false, l, i - 1) * process(chars, true, i + 1, r);
                        break;
                    case '^':
                        res += process(chars, true, l, i - 1) * process(chars, false, i + 1, r);
                        res += process(chars, false, l, i - 1) * process(chars, true, i + 1, r);
                        break;
                }
            }
        } else {
            for (int i = l + 1; i < r; i += 2) {
                switch (chars[i]) {
                    case '&':
                        res += process(chars, true, l, i - 1) * process(chars, false, i + 1, r);
                        res += process(chars, true, l, i - 1) * process(chars, true, i + 1, r);
                        res += process(chars, false, l, i - 1) * process(chars, true, i + 1, r);
                        break;
                    case '|':
                        res += process(chars, false, l, i - 1) * process(chars, false, i + 1, r);
                        break;
                    case '^':
                        res += process(chars, true, l, i - 1) * process(chars, true, i + 1, r);
                        res += process(chars, false, l, i - 1) * process(chars, false, i + 1, r);
                        break;
                }
            }
        }
        return res;
    }

    public static int num2(String exp, boolean desired) {
        if (exp == null || "".equals(exp)) {
            return 0;
        }
        char[] chars = exp.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }
        int[][] t = new int[chars.length][chars.length];
        int[][] f = new int[chars.length][chars.length];
        t[0][0] = chars[0] == '0' ? 0 : 1;
        f[0][0] = chars[0] == '1' ? 0 : 1;
        for (int i = 2; i < chars.length; i += 2) {
            t[i][i] = chars[0] == '0' ? 0 : 1;
            f[i][i] = chars[0] == '1' ? 0 : 1;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (chars[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (f[j][k] + t[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (chars[k + 1] == '|') {
                        t[j][i] += (f[j][k] + t[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += f[j][k] * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += t[j][k] * t[k + 2][i] + f[j][k] * f[k + 2][i];
                    }
                }
            }
        }
        return desired ? t[0][chars.length - 1] : f[0][chars.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(num1("1^0|0|1", false));
        System.out.println(num2("1^0|0|1", false));
    }
}
