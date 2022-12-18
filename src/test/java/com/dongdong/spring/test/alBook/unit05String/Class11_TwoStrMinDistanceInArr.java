package com.dongdong.spring.test.alBook.unit05String;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中两个字符串的最小距离
 */
public class Class11_TwoStrMinDistanceInArr {

    public static int minDistance(String[] strs, String s1, String s2) {
        if (strs == null || s1 == null || s2 == null) {
            return -1;
        }
        if (s1.equals(s2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(s1)) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(s2)) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        String[] ss = {"1", "3", "3", "3", "2", "3", "1"};
        System.out.println(minDistance(ss, "1", "2"));
    }

    public static class Record {

        private HashMap<String, HashMap<String, Integer>> record;

        public Record(String[] strArr) {
            record = new HashMap<String, HashMap<String, Integer>>();
            HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
            for (int i = 0; i < strArr.length; i++) {
                String curStr = strArr[i];
                update(indexMap, curStr, i);
                indexMap.put(curStr, i);
            }

        }

        private void update(HashMap<String, Integer> indexMap, String str, int i) {
            if (!record.containsKey(str)) {
                record.put(str, new HashMap<String, Integer>());
            }
            HashMap<String, Integer> strMap = record.get(str);
            for (Map.Entry<String, Integer> lastEntry : indexMap.entrySet()) {
                String key = lastEntry.getKey();
                int index = lastEntry.getValue();
                if (!key.equals(str)) {
                    HashMap<String, Integer> lastMap = record.get(key);
                    int curMin = i - index;
                    if (strMap.containsKey(key)) {
                        int preMIn = strMap.get(key);
                        if (curMin < preMIn) {
                            strMap.put(key, curMin);
                            lastMap.put(str, curMin);
                        }
                    } else {
                        strMap.put(key, curMin);
                        lastMap.put(str, curMin);
                    }
                }
            }
        }

        public int minDistance(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return -1;
            }
            if (str1.equals(str2)) {
                return 0;
            }
            if (record.containsKey(str1) && record.get(str1).containsKey(str2)) {
                return record.get(str1).get(str2);
            }
            return -1;
        }

        public static void main(String[] args) {
            String[] s = {"1", "3", "3", "3", "2", "3", "1"};
            Record record = new Record(s);
            String str1 = "1";
            String str2 = "2";
            System.out.println(record.minDistance(str1, str2));
        }

    }
}
