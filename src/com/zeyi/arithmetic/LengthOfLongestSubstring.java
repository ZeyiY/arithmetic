package com.zeyi.arithmetic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 给定一个字符串，找出不含有重复字符的最长子串的长度。

 示例 1:

 输入: "abcabcbb"
 输出: 3
 解释: 无重复字符的最长子串是 "abc"，其长度为 3。
 */
public class LengthOfLongestSubstring {
    public static void main(String args[]){

      int l =  lengthOfLongestSubstring("abcabcbb");
      System.out.println("l:"+l);
      System.out.println("lengthOfLongestSubstringSlide:"+lengthOfLongestSubstringSlide("abcabcbb"));
      System.out.println("lengthOfLongestSubstringOptimizeSlide:"+lengthOfLongestSubstringOptimizeSlide("abcabcbb"));
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                if (allUnique(s, i, j)){
                    ans = Math.max(ans, j - i);
                }
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false;
            set.add(ch);
        }
        return true;
    }


    /**
     * 滑动窗口 法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringSlide(String s){
        int n = s.length();
        Set<Character> characters = new HashSet<>();
        int i=0,j=0,ans = 0;
        while (i<n&&j<n){
            if (!characters.contains(s.charAt(j))){
                characters.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                characters.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    /**
     * 优化滑动窗口 法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringOptimizeSlide(String s){
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i=0,j=0;j<n;j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            ans = Math.max(ans,j-i+1);
            map.put(s.charAt(j),j+1);
        }
        return ans;
    }
}
