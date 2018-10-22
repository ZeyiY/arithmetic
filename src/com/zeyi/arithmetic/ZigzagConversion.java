package com.zeyi.arithmetic;

/**
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 *
 *
 * 示例 1:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 3
 * 输出: "PAHNAPLSIIGYIR"
 *
 * 示例 2:
 *
 * 输入: s = "PAYPALISHIRING", numRows = 4
 * 输出: "PINALSIGYAHRPI"
 * 解释:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

public class ZigzagConversion {

    public static void main(String args[]){

        System.out.println(convert("PAYPALISHIRING",3));
    }

    public static String convert(String s, int numRows) {
        if (numRows<2||s.length()<=numRows){
            return s;
        }
        String s1 = "";

        int k = 2*(numRows-1);
        int h = 0;
        int m = numRows-1;

        while (h<s.length()){
            s1 = s1+s.charAt(h);
            h = h+k;
        }

        for (int i=1;i<numRows-1;i++){
            s1 = s1+tt(s,i,numRows-1);
        }

        while (m<s.length()){
            s1 = s1+s.charAt(m);
            m = m+k;
        }


        return s1;
    }

    private static String tt(String s,int n,int t){
        int k = t-n;
        String s1 = "";
        int f = n;

        for (int i=0;i<=s.length()/t;i++){
            if (f>=s.length()){
                break;
            }
            s1 = s1+s.charAt(f);
            if (i%2==0){
                f = f+2*k;
            }else{
                f= f+2*n;
            }

        }
        return s1;
    }


}
