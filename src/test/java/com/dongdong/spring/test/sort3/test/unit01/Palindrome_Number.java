package com.dongdong.spring.test.sort3.test.unit01;

public class Palindrome_Number {

    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        int help = 1;
        while (n / help >= 10) {
            help *= 10;
        }
        while (n > 0) {
            if (n % 10 != n / help) {
                return false;
            }
            n = (n % help) / 10;
            help /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int s = 12321;
        System.out.println(isPalindrome(s));
    }
}
