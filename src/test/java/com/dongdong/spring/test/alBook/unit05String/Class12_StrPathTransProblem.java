package com.dongdong.spring.test.alBook.unit05String;

import org.assertj.core.util.Lists;

import java.util.*;

/**
 * 字符串路径转换问题
 */
public class Class12_StrPathTransProblem {

    public static HashMap<String, List<String>> getNexts(List<String> words) {
        HashSet dict = new HashSet(words);
        HashMap<String, List<String>> nexts = new HashMap<>();
        for (String word : words) {
            nexts.put(word, new ArrayList<>());
        }
        for (String word : words) {
            nexts.put(word, getNext(word, dict));
        }
        return nexts;
    }

    public static List<String> getNext(String word, HashSet<String> dict) {
        List<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char i = 'a'; i <= 'z'; i++)
            for (int j = 0; j < chs.length; j++) {
                if (chs[j] != i) {
                    char temp = chs[j];
                    chs[j] = i;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[j] = temp;
                }
            }
        return res;
    }

    public static HashMap<String, Integer> getDistances(String start, HashMap<String, List<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String str : nexts.get(cur)) {
                if (!set.contains(str)) {
                    distances.put(str, distances.get(cur) + 1);
                    queue.add(str);
                    set.add(str);
                }
            }
        }
        return distances;
    }

    public static List<List<String>> findMinPaths(String start, String to, List<String> list) {
        list.add(start);
        HashMap<String, List<String>> nexts = getNexts(list);
        HashMap<String, Integer> distance = getDistances(start, nexts);
        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(start, to, nexts, distance, pathList, res);
        return res;
    }

    private static void getShortestPaths(String cur, String to,
                                         HashMap<String, List<String>> nexts,
                                         HashMap<String, Integer> distance,
                                         LinkedList<String> solution,
                                         List<List<String>> res) {
        solution.add(cur);
        if (to.equals(cur)) {
            res.add(new LinkedList<>(solution));
        } else {
            for (String next : nexts.get(cur)) {
                if (distance.get(next) == distance.get(cur) + 1) {
                    getShortestPaths(next, to, nexts, distance, solution, res);
                }
            }
        }
        solution.pollLast();
    }

    public static void main(String[] args) {
        String start = "abc";
        String end = "cab";
        List<String> list = Lists.newArrayList("cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb");
        System.out.println(findMinPaths(start,end,list));
    }
}
