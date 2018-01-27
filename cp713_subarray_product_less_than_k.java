//Your are given an array of positive integers nums.
//Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

public class Leetcode713 {
    public static void main(String args[]) {
        int[] nums = {10, 5, 2, 6};
        int result = numSubarrayProductLessThanK(nums, 100);
        System.out.println(result);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1;
        int result = 0;
        int right = 0;
        int left = 0;
        while(right<nums.length) {
            product *= nums[right];
            while(left<=right && product>=k) {
                product /= nums[left++];
            }
            result += right-left+1;
            right++;
        }
        return result;
    }
}
