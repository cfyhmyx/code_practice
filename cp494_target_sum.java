//You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
//Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
//Find out how many ways to assign symbols to make sum of integers equal to target S.

import java.util.Stack;

public class Leetcode494 {
    public static void main(String args[]) {
        int[] nums = {1,1,1,1,1};
        int result = findTargetSumWays(nums, 3);
        System.out.println(result);
    }

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2);
    }

    private static int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }

    /*static private int result = 0;

    public static int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) return result;
        helper(nums, S, 0, 0);
        return result;
    }

    private static void helper(int[] nums, int target, int cur, int sum) {
        if(cur == nums.length) {
            if(sum == target) {
                result++;
            }
            return;
        }
        helper(nums, target, cur+1, sum+nums[cur]);
        helper(nums, target, cur+1, sum-nums[cur]);
    }*/
}
