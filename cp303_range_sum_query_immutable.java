//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

public class Leetcode303 {
    public static void main(String args[]) {

    }

    class NumArray {

        int[] nums;

        public NumArray(int[] nums) {
            for(int i = 1; i < nums.length; i++)
                nums[i] += nums[i - 1];

            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0)
                return nums[j];

            return nums[j] - nums[i - 1];
        }
    }

}
