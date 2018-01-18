//Given an array of 2n integers, your task is to group these integers into n pairs of integer,
//say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

import java.util.Arrays;

public class Leetcode561 {
    public static void main(String args[]) {

    }

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        if(nums == null || nums.length == 0) return sum;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }

}
