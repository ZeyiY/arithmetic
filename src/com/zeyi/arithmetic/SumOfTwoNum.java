package com.zeyi.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumOfTwoNum {

    public static void main(String args[]) throws IllegalArgumentException {


        int [] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        System.out.println(twoSum(nums,target));
    }

    /**
     * 暴力法 O(n平方) O(1)
     * @param nums
     * @param target
     * @return
     * @throws IllegalAccessException
     */
    private static int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     *  哈希表法
     * @param nums
     * @param target
     * @return
     * @throws IllegalArgumentException
     */
    private static int[] twoSumHashTabel(int[] nums,int target) throws IllegalArgumentException{

        Map<Integer,Integer> map = new HashMap<>();
        for(int i= 0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for (int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
            }
        }

        throw  new IllegalArgumentException();

    }

    private static int[] twoSumHashTableOne(int[] nums,int target) throws IllegalArgumentException{

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException();
    }
}
