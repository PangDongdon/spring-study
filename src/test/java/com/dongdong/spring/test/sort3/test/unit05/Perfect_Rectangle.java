package com.dongdong.spring.test.sort3.test.unit05;

import java.util.HashSet;

public class Perfect_Rectangle {

    public static boolean isPerfectRectangle(int[][] arr) {
        if (arr == null || arr[0] == null) {
            return false;
        }
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;
        HashSet<String> set = new HashSet();
        for (int[] rec : arr) {
            x1 = Math.min(rec[0], x1);
            y1 = Math.min(rec[1], y1);
            x2 = Math.max(rec[2], x2);
            y2 = Math.max(rec[3], y2);
            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);
            String s1 = rec[0] + "_" + rec[1];
            String s2 = rec[0] + "_" + rec[3];
            String s3 = rec[2] + "_" + rec[3];
            String s4 = rec[2] + "_" + rec[1];
            if (!set.add(s1)) {
                set.remove(s1);
            }
            if (!set.add(s2)) {
                set.remove(s2);
            }
            if (!set.add(s3)) {
                set.remove(s3);
            }
            if (!set.add(s4)) {
                set.remove(s4);
            }
        }
        if (!set.contains(x1 + "_" + y1) || !set.contains(x1 + "_" + y2) ||
                !set.contains(x2 + "_" + y1) || !set.contains(x2 + "_" + y2) || set.size()!=4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        int[][] arr={{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(isPerfectRectangle(arr));
    }
}
