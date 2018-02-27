//Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

public class Leetcode053 {
    public static void main(String args[]) {
        int[] nums = {1,2};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int temp = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(temp<=0) temp = nums[i];
            else temp += nums[i];
            if(temp > result) result = temp;
        }
        return result;
    }
}
