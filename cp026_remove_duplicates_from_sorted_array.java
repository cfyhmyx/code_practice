//Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

public class Leetcode026 {
    public static void main(String args[]) {
        int[] nums = {1,1,2,3,3,4,5};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 1;
        int cur = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == cur) continue;
            cur = nums[i];
            nums[index++] = cur;
        }
        return index;
    }
}
