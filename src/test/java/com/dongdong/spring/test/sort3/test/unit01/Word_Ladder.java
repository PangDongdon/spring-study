package com.dongdong.spring.test.sort3.test.unit01;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class Word_Ladder {


    public static List<List<String>> findLadders(String begin, String end, List<String> wordList) {
        wordList.add(begin);
        //获取当前字符串的一个不同的字符
        HashMap<String, ArrayList<String>> nexts = getNexts(wordList);
        //获取字典表中与begin 距离的映射关系
        HashMap<String, Integer> distance = getDistance(begin, nexts);
        LinkedList<String> pathlist = new LinkedList<>();
        List<List<String>> res = new LinkedList<>();
        getShortestPaths(begin, end, nexts, distance, pathlist, res);
        return  res;
    }

    private static void getShortestPaths(String begin, String end, HashMap<String, ArrayList<String>> nexts, HashMap<String, Integer> distance, LinkedList<String> pathlist, List<List<String>> res) {
        pathlist.add(begin);
        if (begin.equals(end)) {
            res.add(new LinkedList<>(pathlist));
        } else {
            for(String next:nexts.get(begin)){
                if(distance.get(next)==distance.get(begin)+1){
                    getShortestPaths(begin, end, nexts, distance, pathlist, res);
                }
            }
        }
        pathlist.pollLast();
    }

    private static HashMap<String, ArrayList<String>> getNexts(List<String> words) {
        Set<String> dict = new HashSet<>(words);
        HashMap<String, ArrayList<String>> nexts = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), new ArrayList<>());
        }
        for (int i = 0; i < words.size(); i++) {
            nexts.put(words.get(i), getNext(words.get(i), dict));
        }
        return nexts;
    }


    private static ArrayList<String> getNext(String word, Set<String> list) {
        ArrayList<String> res = new ArrayList<>();
        if (StringUtils.isBlank(word) || CollectionUtils.isEmpty(list)) {
            return res;
        }
        char[] chars = word.toCharArray();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < chars.length; j++) {
                char temp = chars[j];
                chars[j] = i;
                if (list.contains(String.valueOf(chars))) {
                    res.add(String.valueOf(chars));
                }
                chars[i] = temp;
            }
        }
        return res;
    }

    private static HashMap<String, Integer> getDistance(String begin, HashMap<String, ArrayList<String>> nexts) {
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(begin, 0);
        LinkedList<String> queue = new LinkedList();
        queue.add(begin);
        Set<String> isAdd = new HashSet<>();
        isAdd.add(begin);
        while (!queue.isEmpty()) {
            String ss = queue.poll();
            for (String s : nexts.get(ss)) {
                if (!isAdd.contains(s)) {
                    distance.put(s, distance.get(s) + 1);
                    isAdd.add(s);
                    queue.add(s);
                }
            }
        }
        return distance;
    }
}
