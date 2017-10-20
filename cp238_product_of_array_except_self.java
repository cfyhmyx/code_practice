//Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//Solve it without division and in O(n).

import java.util.Arrays;

public class Leetcode238 {
    public static void main(String args[]) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }

    //constant space
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int left = 1;
        int right = 1;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for(int i=1; i<n; i++) {
            left = left*nums[i-1];
            right = right*nums[n-i];
            result[i] *= left;
            result[n-1-i] *= right;
        }
        return result;
    }

    /*public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for(int i=1; i<nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[i] = right[i-1]*nums[n-i];
        }
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = left[i]*right[n-1-i];
        }
        return result;
    }*/

}
