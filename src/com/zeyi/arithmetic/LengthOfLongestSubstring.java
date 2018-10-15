package com.zeyi.arithmetic;

import java.util.HashSet;
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
}
