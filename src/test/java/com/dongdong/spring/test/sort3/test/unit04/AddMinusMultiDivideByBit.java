package com.dongdong.spring.test.sort3.test.unit04;

import net.dongliu.commons.Sys;

public class AddMinusMultiDivideByBit {

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int reverseNum(int n) {
        return add(~n, 1);
    }

    public static int minus(int a, int b) {
        return add(a, reverseNum(b));
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? reverseNum(a) : a;
        int y = isNeg(b) ? reverseNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i=minus(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = minus(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? reverseNum(res) : res;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("divisor is 0");
        }
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (b == Integer.MIN_VALUE) {
            return 0;
        } else if (a == Integer.MIN_VALUE) {
            int res = div(add(a, 1), b);
            return add(res, div(minus(a, multi(res, b)), b));
        } else {
            return div(a, b);
        }
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(minus(2, 3));
        System.out.println(multi(2, 3));
        System.out.println(div(4, 2));
    }
}
