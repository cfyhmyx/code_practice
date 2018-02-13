//Given an unsorted array of integers, find the length of longest increasing subsequence.
//For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing subsequence is [2, 3, 7, 101],
//therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

public class Leetcode300 {
    public static void main(String args[]) {
        int[] nums = {3,4,-1,5,8,2,3,12,7,9,10};
        int result = lengthOfLIS(nums);
        System.out.println(result);
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = binarySearch(dp, 0, len-1, x);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }

    public static int binarySearch(int[] dp, int left, int right, int num) {
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(dp[mid] == num) return mid;
            else if(dp[mid] > num) {
                right = mid-1;
            } else if(dp[mid] < num) {
                left = mid+1;
            }
        }
        return left;
    }

}
