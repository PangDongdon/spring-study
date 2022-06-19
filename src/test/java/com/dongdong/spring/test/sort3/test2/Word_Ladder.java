package com.dongdong.spring.test.sort3.test2;

import java.util.*;

public class Word_Ladder {

    public static List<String> getNext(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != i) {
                    char temp = arr[j];
                    arr[j] = i;
                    if (dict.contains(String.valueOf(arr))) {
                        res.add(String.valueOf(arr));
                    }
                    arr[j] = temp;
                }
            }
        }
        return res;
    }

    public static HashMap<String, List<String>> getNexts(List<String> words) {
        HashSet<String> dict = new HashSet<>(words);
        HashMap<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < words.size(); i++) {
            res.put(words.get(i), new ArrayList<>());
        }

        for (int i = 0; i < words.size(); i++) {
            res.put(words.get(i), getNext(words.get(i), dict));
        }
        return res;
    }

    public static HashMap<String, Integer> getDistance(String begin, HashMap<String, List<String>> nexts) {
        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(begin, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        HashSet sets = new HashSet();
        sets.add(begin);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (String s : nexts.get(cur)) {
                if (!sets.contains(s)) {
                    queue.add(s);
                    sets.add(s);
                    distance.put(s, distance.get(cur) + 1);
                }
            }
        }
        return distance;
    }

    private static void getShortestPaths(String cur, String end,
                                         HashMap<String, ArrayList<String>> nexts,
                                         HashMap<String, Integer> distances, LinkedList<String> solution,
                                         List<List<String>> res) {

        solution.add(cur);
        if(end.equals(cur)){
            res.add(new LinkedList<>(solution));
        }else{
          for(String next:nexts.get(cur)){
              if(distances.get(next)==distances.get(cur)+1){
                  getShortestPaths(next, end, nexts, distances, solution, res);
              }
          }
        }
        solution.pollLast();
    }

}
