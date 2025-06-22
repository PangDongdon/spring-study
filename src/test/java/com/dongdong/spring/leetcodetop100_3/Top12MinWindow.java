package com.dongdong.spring.leetcodetop100_3;

/**
 * 最小覆盖子串
 */
public class Top12MinWindow {
    public String minWindow(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if (sLength < 0 || tLength < 0 || sLength < tLength) {
            return "";
        }
        final char[] charS = s.toCharArray();
        final char[] charsT = t.toCharArray();
        char[] winFreqS = new char[128];
        char[] winFreqT = new char[128];
        for (char c : charsT) {
            winFreqT[c]++;
        }
        int distance = 0;
        int minLen = sLength + 1;
        int begin = 0;
        int left=0;
        int right=0;
        while (right < sLength) {
            if(winFreqT[charS[right]]==0){
                right++;
                continue;
            }
            if (winFreqS[charS[right]] < winFreqT[charS[right]]) {
                distance++;
            }
            winFreqS[charS[right]]++;
            right++;
            while (distance == tLength) {
                if(minLen>right-left){
                    minLen=right-left;
                    begin=left;
                }
                if(winFreqT[charS[left]]==0){
                    left++;
                    continue;
                }
                if (winFreqS[charS[left]] == winFreqT[charS[left]]) {
                    distance--;
                }
                winFreqS[charS[left]]--;
                left++;
            }
        }
        if (minLen==sLength+1){
            return "";
        }
        return s.substring(begin,begin+minLen);
    }
}
