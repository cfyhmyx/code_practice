//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//You may assume no duplicate exists in the array.

public class Leetcode033 {
    public static void main(String args[]) {
        int[] nums = {3, 1};
        int result = search(nums, 3);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target ) {
                return mid;
            } else if(nums[mid] > target) {
                if(nums[mid] >= nums[low] && nums[low] > target) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                if(nums[mid] <= nums[high-1] && nums[high-1] < target) {
                    high = mid;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
