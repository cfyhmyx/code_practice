//Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.
//And you need to output the maximum average value.

public class Leetcode643 {
    public static void main(String args[]) {
        int[] nums = {1,12,-5,-6,50,3};
        double result = findMaxAverage(nums, 4);
        System.out.println(result);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double result = 0;
        if(k>nums.length || k<=0) return result;
        int start = 0;
        for(int i=0; i<k; i++) {
            result += nums[i];
        }
        double cur = result;
        for(int i=k; i<nums.length; i++,start++) {
            cur = cur-nums[start]+nums[i];
            result = Math.max(cur, result);
        }
        return result/k;
    }
}
