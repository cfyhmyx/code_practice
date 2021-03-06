//Write a program to find the n-th ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
//For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//Note that 1 is typically treated as an ugly number, and n does not exceed 1690.

public class Leetcode264 {
    public static void main(String args[]) {
    }

    public static int nthUglyNumber(int n) {
        int[] nums = new int[n];
        int index2=0, index3=0, index5=0;
        nums[0] = 1;
        for(int i=1; i<nums.length; i++) {
            nums[i] = Math.min(nums[index2]*2, Math.min(nums[index3]*3, nums[index5]*5));
            if(nums[i] == nums[index2]*2) index2++;
            if(nums[i] == nums[index3]*3) index3++;
            if(nums[i] == nums[index5]*5) index5++;
        }
        return nums[n-1];
    }

}
