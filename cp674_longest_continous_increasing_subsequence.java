//Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

public class Leetcode674 {
    public static void main(String args[]) {
        int[] nums = {1,2,22,222};
        int result = findLengthOfLCIS(nums);
        System.out.println(result);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int result = 0;
        if(nums.length == 0) return result;
        int local = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                local++;
            } else {
                result = Math.max(result, local);
                local = 1;
            }
        }
        return Math.max(result,local);
    }
}
