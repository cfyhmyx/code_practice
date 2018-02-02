//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Write a function to determine if a given target is in the array.
//The array may contain duplicates.

public class Leetcode081 {
    public static void main(String args[]) {

    }

    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target ) {
                return true;
            } else if(nums[mid] == nums[low] && nums[mid] == nums[high-1]) {
                low++;
                high--;
            }else if(nums[mid] > target) {
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
        return false;
    }
}
