package com.dongdong.spring.leetcode;

import com.dongdong.spring.test.alBook.Utils;
import lombok.val;

import java.util.*;

/**
 * 合并区间
 */
public class Top14Merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null) {
            return null;
        }
        List<Range> rangeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length - 1; j++) {
                rangeList.add(new Range(intervals[i][j], intervals[i][j + 1]));
            }
        }
        Collections.sort(rangeList, new RangeSort());
        List<Range> rangeList2 = new ArrayList<>();
        for (int i = 0; i < rangeList.size(); i++) {
            Range range = rangeList.get(i);
            Range range1 = null;
            if (i + 1 < rangeList.size()) {
                range1 = rangeList.get(i + 1);
            }
            if (range1 != null && range1.start >= range.start && range1.start <= range.end && range.end <= range1.end
            ) {
                rangeList2.add(new Range(range.start, range1.end));
                i++;
            } else {
                rangeList2.add(new Range(range.start, range.end));
            }
        }
        int[][] res = new int[rangeList2.size()][intervals[0].length];
        for (int i = 0; i < rangeList2.size(); i++) {
            res[i] = new int[]{rangeList2.get(i).start, rangeList2.get(i).end};
        }
        return res;
    }

    public static class Range {
        private int start;
        private int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static class RangeSort implements Comparator<Range> {
        @Override
        public int compare(Range o1, Range o2) {
            return o1.start - o2.start;
        }
    }


    public static int[][] merge2(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (res.get(res.size() - 1)[1] < L) {
                res.add(new int[]{L, R});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], R);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        //示例 1：
        //
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        //解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
        //示例 2：
        //
        //输入：intervals = [[1,4],[4,5]]
        //输出：[[1,5]]
        //解释：区间 [1,4] 和 [4,5] 可被视为重叠区间
       /* int[][] s = {{1, 4}, {4, 5}};
        Utils.printData(merge(s));*/

        int[][] s2 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Utils.printData(merge(s2));
    }
}
