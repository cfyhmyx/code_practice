//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Find the minimum element. You may assume no duplicate exists in the array.

public class Leetcode153 {
    public static void main(String args[]) {
        int[] nums = {4,5,6,7,0,1,2};
        int result = findMin(nums);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(nums[mid] >= nums[low]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

}
