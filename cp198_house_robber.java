//https://leetcode.com/problems/house-robber/description/

public class Leetcode198 {
    public static void main(String args[]) {
        int[] nums = {2, 6, 3, 7, 8, 6, 9};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int m = nums.length;
        if(m<1) return 0;
        int[] dp = new int[m+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=m; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[m];
    }

}
