//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Your goal is to reach the last index in the minimum number of jumps.
//For example: Given array A = [2,3,1,1,4]
//The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//Note: You can assume that you can always reach the last index.

public class Leetcode045 {
    public static void main(String args[]) {
        int[] nums = {3,2,1,0,4};
        int step = jump(nums);
        System.out.println(step);
    }

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0;
        int end = -1;
        int step = 0;
        int newEnd = 0;
        while(newEnd > end) {
            end = newEnd;
            step++;
            while (start <= end) {
                newEnd = Math.max(newEnd,start + nums[start]);
                if (newEnd >= nums.length - 1) {
                    return step;
                }
                start++;
            }
        }
        return Integer.MAX_VALUE;
    }
}
