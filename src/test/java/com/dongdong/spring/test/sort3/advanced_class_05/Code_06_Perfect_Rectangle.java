package advanced_class_05;

import java.util.HashSet;

public class Code_06_Perfect_Rectangle {

    public static boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles[0].length == 0) {
            return false;
        }
        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE;
        int y2 = Integer.MIN_VALUE;
        HashSet<String> set = new HashSet<String>();
        int area = 0;
        for (int[] rect : rectangles) {
            x1 = Math.min(rect[0], x1);
            y1 = Math.min(rect[1], y1);
            x2 = Math.max(rect[2], x2);
            y2 = Math.max(rect[3], y2);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            String s1 = rect[0] + "_" + rect[1];
            String s2 = rect[0] + "_" + rect[3];
            String s3 = rect[2] + "_" + rect[3];
            String s4 = rect[2] + "_" + rect[1];
            if (!set.add(s1)) set.remove(s1);
            if (!set.add(s2)) set.remove(s2);
            if (!set.add(s3)) set.remove(s3);
            if (!set.add(s4)) set.remove(s4);
        }
        if (!set.contains(x1 + "_" + y1) || !set.contains(x1 + "_" + y2)
                || !set.contains(x2 + "_" + y1) || !set.contains(x2 + "_" + y2)
                || set.size() != 4) {
            return false;
        }
        return area == (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        System.out.println(isRectangleCover(arr));
    }
}
