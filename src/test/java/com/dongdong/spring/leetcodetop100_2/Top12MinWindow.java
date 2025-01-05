package com.dongdong.spring.leetcodetop100_2;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

/**
 *最小覆盖子串
 */
public class Top12MinWindow {

    Map<Character,Integer> ori=new HashMap<>();
    Map<Character,Integer> cnt=new HashMap<>();

    public String minWindow(String s, String t) {
      int sLen=s.length();
      int tLen=t.length();
      if (sLen==0 || tLen==0 || sLen<tLen){
          return "";
      }
      char[] charsS = s.toCharArray();
      char[] charsT=t.toCharArray();
      char[] winFreqS=new char[128];
      char[] winFreqT=new char[128];
      for(char c:charsT){
          winFreqT[c]++;
      }
      int distance=0;
      int minLen=sLen+1;
      int begin=0;
      int left=0;
      int right=0;
      while (right<sLen){
           if(winFreqT[charsS[right]]==0){
               right++;
               continue;
           }
          if(winFreqS[charsS[right]]<winFreqT[charsS[right]]) {
              distance++;
          }
          winFreqS[charsS[right]]++;
          right++;

          while (distance==tLen){
              if(right-left<minLen){
                  minLen=right-left;
                  begin=left;
              }

              if(winFreqT[charsS[left]]==0){
                  left++;
                  continue;
              }
              if(winFreqS[charsS[left]]==winFreqT[charsS[left]]) {
                  distance--;
              }
              winFreqS[charsS[left]]--;
              left++;
          }
      }
      if(minLen==sLen+1){
          return "";
      }
      return s.substring(begin,begin+minLen);
    }



    public String minWindow2(String s, String t) {
        int sLen=s.length();
        int tLen=t.length();
        if (sLen==0 || tLen==0 || sLen<tLen){
            return "";
        }
        char[] charsS = s.toCharArray();
        char[] charsT=t.toCharArray();
        char[] winFreqS=new char[128];
        char[] winFreqT=new char[128];
        for(char c:charsT){
            winFreqT[c]++;
        }
        int distance=0;
        int minLen=sLen+1;
        int begin=0;
        int left=0;
        int right=0;
        while (right<sLen){
            if(winFreqT[charsS[right]]==0){
                right++;
                continue;
            }
            if(winFreqS[charsS[right]]<winFreqT[charsS[right]]) {
                distance++;
            }
            winFreqS[charsS[right]]++;
            right++;

            while (distance==tLen){
                if(right-left<minLen){
                    minLen=right-left;
                    begin=left;
                }

                if(winFreqT[charsS[left]]==0){
                    left++;
                    continue;
                }
                if(winFreqS[charsS[left]]==winFreqT[charsS[left]]) {
                    distance--;
                }
                winFreqS[charsS[left]]--;
                left++;
            }
        }
        if(minLen==sLen+1){
            return "";
        }
        return s.substring(begin,begin+minLen);
    }
}
