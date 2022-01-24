package com.dongdong.spring.test.sort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Program {
        private int start;
        private int end;
    }

    public static class MyComparator implements Comparator<Program> {
        @Override
        public int compare(Program p1, Program p2) {
            return p1.end - p2.end;
        }
    }

    public static int getBestArrange(Program[] programs, int start) {
        //check
        if (programs == null || programs.length < 1) {
            return 0;
        }
        //sort
        Arrays.sort(programs, new MyComparator());
        int result = 0;
        //total
        for (Program program : programs) {
            if (start <= program.start) {
                result++;
                start = program.end;
            }
        }
        return result;
    }
}
