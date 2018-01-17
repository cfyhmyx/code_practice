//Given an array of integers, every element appears twice except for one. Find that single one.
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Leetcode136 {
    public static void main(String args[]) {

    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num : nums) {
            result ^= num;
        }
        return result;
    }

}
