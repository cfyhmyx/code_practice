//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.

import java.util.HashMap;
import java.util.Map;

public class Leetcode001 {

     public static void main(String args[]) {
        int[] nums = {1,4,3,3};
        int result[] = twoSum(nums, 6);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
     }

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
