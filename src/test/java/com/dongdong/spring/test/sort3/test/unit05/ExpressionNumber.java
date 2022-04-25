package com.dongdong.spring.test.sort3.test.unit05;

import org.apache.logging.log4j.util.Strings;

public class ExpressionNumber {

    private static boolean isValidExpression(char[] chars) {
        int length = chars.length;
        if (chars == null || (length & 1) == 0) {
            return false;
        }
        for (int i = 0; i < length; i += 2) {
            if ((chars[i] != '1') && (chars[i] != '0')) {
                return false;
            }
        }
        for (int i = 1; i < length; i += 2) {
            if ((chars[i] != '&') && (chars[i] != '|') && (chars[i] != '^')) {
                return false;
            }
        }
        return true;
    }

    public static class ReturnData {
        private int trueNums;
        private int falseNums;

        public ReturnData(int trueNums, int falseNums) {
            this.trueNums = trueNums;
            this.falseNums = falseNums;
        }
    }

    private static ReturnData getInvalidNum(char[] arr, int L, int R) {
        if (L == R) {
            if (arr[L] == '0') {
                return new ReturnData(0, 1);
            } else {
                return new ReturnData(1, 0);
            }
        }
        int trueNums = 0;
        int falseNums = 0;
        for (int i = L + 1; i < R; i += 2) {
            ReturnData leftData = getInvalidNum(arr, L, i - 1);
            ReturnData rightData = getInvalidNum(arr, i + 1, R);
            int a = leftData.trueNums;
            int b = leftData.falseNums;
            int c = rightData.trueNums;
            int d = rightData.falseNums;
            if (arr[i] == '&') {
                trueNums += a * c;
                falseNums += a * d + b * c + b * d;
            } else if (arr[i] == '|') {
                trueNums += a * c + a * d + c * b;
                falseNums += b * d;
            } else {//^
                trueNums += a * d + b * c;
                falseNums += a * c + b * d;
            }
        }
        return new ReturnData(trueNums, falseNums);
    }

    public static int getNum(String s, boolean aim) {
        if (Strings.isBlank(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        ReturnData invalidNum = getInvalidNum(chars, 0, chars.length - 1);
        return aim ? invalidNum.trueNums : invalidNum.falseNums;
    }

    public static void main(String[] args) {
        String express = "1^0&0|1&1^0&0^1|0|1&1";
        boolean desired = true;
        System.out.println(getNum(express, desired));
        System.out.println(getNums2(express, desired));
    }

    public static int getNums2(String s, boolean aim) {
        if (Strings.isBlank(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        if (!isValidExpression(chars)) {
            return 0;
        }
        if (length == 1) {
            return aim ? ("1".equals(s) ? 1 : 0) : ("0".equals(s) ? 0 : 1);
        }
        //定义true false 数组
        int[][] trueNumsDp = new int[length][length];
        int[][] falseNumsDp = new int[length][length];

        for (int i = 0; i < length; i += 2) {
            trueNumsDp[i][i] = chars[i] == '1' ? 1 : 0;
            falseNumsDp[i][i] = chars[i] == '0' ? 1 : 0;
        }

        for (int row = length - 3; row > -1; row -= 2) {
            for (int clo = row + 2; clo < length; clo += 2) {
                int trueNums = 0;
                int falseNums = 0;
                for (int split = row + 1; split < clo; split += 2) {
                    int a = trueNumsDp[row][split - 1];
                    int b = falseNumsDp[row][split - 1];
                    int c = trueNumsDp[split + 1][clo];
                    int d = falseNumsDp[split + 1][clo];
                    if (chars[split] == '&') {
                        trueNums += a * c;
                        falseNums += a * d + b * c + b * d;
                    } else if (chars[split] == '|') {
                        trueNums += a * c + a * d + c * b;
                        falseNums += b * d;
                    } else {//^
                        trueNums += a * d + b * c;
                        falseNums += a * c + b * d;
                    }
                }
                trueNumsDp[row][clo] = trueNums;
                falseNumsDp[row][clo] = falseNums;
            }
        }
        return aim ? trueNumsDp[0][length - 1] : falseNumsDp[0][length - 1];
    }

}
