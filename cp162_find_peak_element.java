//A peak element is an element that is greater than its neighbors.
//Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//You may imagine that num[-1] = num[n] = -∞.
//For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

public class Leetcode162 {
    public static void main(String args[]) {
        int[] nums = {2,1};
        int peak = findPeakElement(nums);
        System.out.println(nums[peak]);
    }

    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;
        while(start < end) {
            int mid = start + (end-start)/2;
            if(mid > start && nums[mid] < nums[mid-1]) {
                end = mid;
            } else if (mid > start && nums[mid] > nums[mid-1]) {
                start = mid;
            } else{
                break;
            }
        }
        return start;
    }

}