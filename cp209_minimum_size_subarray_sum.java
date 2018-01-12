//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s.
//If there isn't one, return 0 instead.
//For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.

public class Leetcode209 {
    public static void main(String args[]) {
        int[] nums = {2,3,1,2,4,3};
        int result = minSubArrayLen(7, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right<nums.length) {
            sum += nums[right];
            right++;
            while(sum >= s){
                result = Math.min(result, right-left);
                sum -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
