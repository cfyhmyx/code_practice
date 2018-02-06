//https://leetcode.com/problems/house-robber-ii/description/

public class Leetcode213 {
    public static void main(String args[]) {
        int[] nums = {8, 6, 3, 7, 8, 6, 9};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private static int rob(int[] nums, int low, int high) {
        int prevNo = 0;
        int prevYes = 0;
        for(int i=low; i<=high; i++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i];
        }
        return Math.max(prevNo, prevYes);
    }

    //O(n) space
    /*public static int rob(int[] nums) {
        int m = nums.length;
        if(m<1) return 0;
        if(m==1) return nums[0];
        int[] dp = new int[m+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=m-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        int withoutLast = dp[m-1];
        dp[1] = 0;
        for(int i=2; i<=m; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        int withLast = dp[m];
        return Math.max(withLast, withoutLast);
    }*/

}
