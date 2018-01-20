//Given an unsorted integer array, find the first missing positive integer.
//Your algorithm should run in O(n) time and uses constant space.

public class Leetcode041 {
    public static void main(String args[]) {
            int[] nums = {1,1};
            int result = firstMissingPositive(nums);
            System.out.println(result);
        }

    public static int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        for(int i=0; i<nums.length; i++) {
            for(int j=nums[i]; j!=i+1&&j<=nums.length&&j>0&&j!=nums[j-1]; j=nums[i] ){
                int temp = nums[i];
                nums[i] = nums[j-1];
                nums[j-1] = temp;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
