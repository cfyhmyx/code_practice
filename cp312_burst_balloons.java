//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
//You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
//Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
//Find the maximum coins you can collect by bursting the balloons wisely.
//Note:
//(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
//(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

public class Leetcode312 {
    public static void main(String args[]) {
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i=0; i<n; i++) {
            arr[i+1] = nums[i];
        }
        arr[0] = arr[n+1] = 1;
        int[][] dp = new int[n+2][n+2];
        return helper(1, n, arr, dp);
    }

    private int helper(int i, int j, int[] nums, int[][] dp) {
        if(i>j) return 0;
        if(dp[i][j] > 0) return dp[i][j];
        for(int x=i; x<=j; x++) {
            dp[i][j] = Math.max(dp[i][j], helper(i, x-1, nums, dp)
                                            +nums[i-1]*nums[x]*nums[j+1]
                                            +helper(x+1, j, nums, dp));
        }
        return dp[i][j];
    }

}
