package com.zeyi.arithmetic;

public class ContainerWithMostWater {
    public static void main(String agrs[]){
        int [] hei = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(hei));
    }

    public static int maxArea(int[] height) {
        int re = 0;
        for (int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int t = Math.min(height[i],height[j])*(j-i);
                if (re<t){
                    re = t;
                }
            }
        }



        return re;
    }
}
