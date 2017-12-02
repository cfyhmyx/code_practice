//Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.s

public class Leetcode034 {
    public static void main(String args[]) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int start = -1;
        int end = -1;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target) {
                start = mid;
                while(start>0 && nums[start-1] == target) {
                    start--;
                }
                end = mid;
                while(end<nums.length-1 && nums[end+1] == target) {
                    end++;
                }
                break;
            } else if(nums[mid] > target) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return new int[] {start, end};
    }
}
