package com.zeyi.arithmetic;

/**
 *
 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。

 示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 */
public class LongestPalindrome {
    public static void main(String args[]){
        System.out.println(longestPalindrome("babad"));
    }

    /**
     * 暴力法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s == null || s.length() < 1||s.length()>1000) return "";
        String st = "";

        for (int i = 0;i<s.length();i++){
            for (int j=i;j<=s.length();j++){
                String s1 = s.substring(i,j);
                if (checkPalindrome(s1)){
                    if (s1.length()>st.length()){
                        st = s1;
                    }
                }
            }
        }
        return st;
    }

    private static boolean checkPalindrome(String s){
        if (s.length()==0){
            return false;
        }
        if (s.length()==1){
            return true;
        }
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     *  中心扩展算法
     * @param s
     * @return
     */

    public String longestPalindromeCentenr(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
