//Given an array of size n, find the majority element.
//The majority element is the element that appears more than ⌊n/2⌋ times.
//You may assume that the array is non-empty and the majority element always exist in the array.
public class Leetcode169 {
    public static void main(String args[]) {
        int[] nums = {3,3,4};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int num = 1;
        for(int i=1; i<nums.length; i++) {
            if(num == 0) {
                majority = nums[i];
                num = 1;
            } else {
                num = nums[i] == majority ? num+1 : num-1;
            }
        }
        return majority;
    }

}
