//In a given integer array nums, there is always exactly one largest element.
//Find whether the largest element in the array is at least twice as much as every other number in the array.
//If it is, return the index of the largest element, otherwise return -1.

public class Leetcode747 {
    public static void main(String args[]) {

    }

    public int dominantIndex(int[] nums) {
        if(nums.length == 1) return 0;
        int max = nums[0];
        int second = 0;
        int maxIndex = 0;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > max) {
                second = max;
                max = nums[i];
                maxIndex = i;
            } else if(nums[i] > second) {
                second = nums[i];
            }
        }
        if(second == 0 || max/second >= 2) {
            return maxIndex;
        }
        return -1;
    }

}