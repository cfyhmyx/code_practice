//A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S,
//where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
//Suppose the first element in S starts with the selection of element A[i] of index = i,
//the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy,
//we stop adding right before a duplicate element occurs in S.

import java.util.HashSet;

public class Leetcode565 {
    public static void main(String args[]) {
        int[] nums = {5,4,0,3,1,6,2};
        int res = arrayNesting(nums);
        System.out.println(res);
    }

    public static int arrayNesting(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            int count = 0;
            while (nums[index] >= 0) {
                int newIndex = nums[index];
                nums[index] = -1;
                index = newIndex;
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }

    //dfs
    /*public static int arrayNesting(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            HashSet<Integer> set = new HashSet<>();
            max = Math.max(max, helper(dp, nums, set, i));
        }
        return max;
    }

    private static int helper(int[] dp, int[] nums, HashSet<Integer> set, int index) {
        if(dp[index] > 0) return dp[index];
        if(set.contains(nums[index])) {
            return 0;
        }
        set.add(nums[index]);
        dp[index] = 1+helper(dp, nums, set, nums[index]);
        return dp[index];
    }*/
}
