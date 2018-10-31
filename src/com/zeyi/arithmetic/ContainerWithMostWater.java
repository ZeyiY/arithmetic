package com.zeyi.arithmetic;

public class ContainerWithMostWater {
    public static void main(String agrs[]){
        int [] hei = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(hei));
        System.out.println(doubleMaxArea(hei));
    }

    /**
     *  暴力法
     * @param height
     * @return
     */
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

    /**
     * 双指针法
     * @param height
     * @return
     */
    public static int doubleMaxArea(int[] height){
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
