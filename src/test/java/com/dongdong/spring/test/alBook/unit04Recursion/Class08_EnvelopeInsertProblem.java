package com.dongdong.spring.test.alBook.unit04Recursion;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

//信封镶嵌问题
public class Class08_EnvelopeInsertProblem {

    @Data
    @AllArgsConstructor
    static class Envelope {
        private int len;
        private int wid;


    }

    class EnvelopeComparator implements Comparator<Envelope> {

        @Override
        public int compare(Envelope o1, Envelope o2) {
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o2.wid;
        }
    }

    public Envelope[] getSortedEnvelope(int[][] matrix) {
        Envelope[] res = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopeComparator());
        return res;
    }

    public int maxEnvelopes(int[][] matrix) {
        Envelope[] envelopes = getSortedEnvelope(matrix);
        int[] ends = new int[matrix.length];
        ends[0] = envelopes[0].wid;
        int right = 0;
        int l = 0;
        int r = 0;
        int m = 0;
        for (int i = 1; i < envelopes.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (envelopes[i].wid > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, i);
            ends[l] = envelopes[i].wid;
        }
        return right + 1;
    }

}
