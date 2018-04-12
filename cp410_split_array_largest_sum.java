//Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays.
//Write an algorithm to minimize the largest sum among these m subarrays.

public class Leetcode410 {
    public static void main(String args[]) {
        int[] A = {7,2,5,10,8};
        double result = splitArray(A, 2);
        System.out.println(result);
    }

    public static int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public static boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }

    //dp
    /*public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n+1][m+1];
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            dp[i+1][1] = sum;
        }
        return helper(nums, dp, n, m);
    }

    private static int helper(int[] nums, int[][] dp, int n, int m) {
        if(dp[n][m] > 0) return dp[n][m];
        dp[n][m] = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=n-1; i>0; i--) {
            sum += nums[i];
            dp[n][m] = Math.min(dp[n][m], Math.max(helper(nums, dp, i, m-1), sum));
        }
        return dp[n][m];
    }*/

}
