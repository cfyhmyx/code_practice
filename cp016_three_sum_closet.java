//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
//Return the sum of the three integers. You may assume that each input would have exactly one solution.

import java.util.Arrays;

public class Leetcode016 {
    public static void main(String args[]) {
        int[] nums = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        int result = threeSumClosest(nums,-52);
        System.out.println(result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int distance = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int m = nums.length;
        for(int i=0; i<m-2; i++) {
            int low = i+1;
            int high = m-1;
            while(low<high) {
                if(nums[i]+nums[low]+nums[high]>target) {
                    if(Math.abs(nums[i]+nums[low]+nums[high]-target)<distance) {
                        result = nums[i]+nums[low]+nums[high];
                        distance = Math.abs(nums[i]+nums[low]+nums[high]-target);
                    }
                    high--;
                } else if(nums[i]+nums[low]+nums[high]<target) {
                    if(Math.abs(nums[i]+nums[low]+nums[high]-target)<distance) {
                        result = nums[i]+nums[low]+nums[high];
                        distance = Math.abs(nums[i]+nums[low]+nums[high]-target);
                    }
                    low++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
