//Given a sorted array and a target value, return the index if the target is found.
//If not, return the index where it would be if it were inserted in order.

public class Leetcode035 {
    public static void main(String args[]) {
        int[] nums = {1,3,5,6};
        int result = searchInsert(nums, 0 );
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] >target) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return high;
    }
}
