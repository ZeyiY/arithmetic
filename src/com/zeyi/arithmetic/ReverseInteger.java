package com.zeyi.arithmetic;

/**
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
public class ReverseInteger {
    public static void main(String args[]){


        System.out.println(reverse(1534236469));
    }

    public static int reverse(int x) {

        String str = String.valueOf(x);
        if (x<0){
            str = str.substring(1,str.length());
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder = stringBuilder.reverse();
        if (x<0){
            stringBuilder = new StringBuilder("-").append(stringBuilder);
        }
        int num = 0;
        try{
            num = Integer.valueOf(stringBuilder.toString());
        }catch (Exception e){

        }
        return num;
    }
}
