//Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Leetcode137 {
    public static void main(String args[]) {

    }

    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

}
