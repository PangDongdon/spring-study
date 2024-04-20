package com.dongdong.spring.leetcode;

import lombok.val;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 最小覆盖子串
 */
public class Top12MinWindow {

    static Map<Character, Integer> tmap = new HashMap();
    static Map<Character, Integer> cnt = new HashMap();

    public static String minWindow(String s, String t) {
        if (StringUtils.isEmpty(s) || StringUtils.isEmpty(t) || s.length() < t.length()) {
            return "";
        }
        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            Character c = t.charAt(i);
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = -1;
        int sLength = s.length();
        int anl = -1, anr = -1;
        int len = Integer.MAX_VALUE;
        while (r < sLength) {
            ++r;
            if (r < sLength && tmap.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    anl = l;
                    anr = l + len;
                }

                if (tmap.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }

                ++l;
            }
        }
        return anr == -1 ? "" : s.substring(anl, anr);
    }

    private static boolean check() {
        Iterator iterator = tmap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry next = (Map.Entry) iterator.next();
            Character key = (Character) next.getKey();
            Integer value = (Integer) next.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //输入：s = "ADOBECODEBANC", t = "ABC"
        //输出："BANC"
        //解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     /*   String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
*/
        //输入：s = "a", t = "a"
        //输出："a"
        //解释：整个字符串 s 是最小覆盖子串。
        String s1 = "a";
        String t1 = "a";
        System.out.println(minWindow(s1, t1));
    }

}
