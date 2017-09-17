//Given an array of non-negative integers, you are initially positioned at the first index of the array.
//Each element in the array represents your maximum jump length at that position.
//Determine if you are able to reach the last index.
public class Leetcode055 {
    public static void main(String args[]) {
        int[] nums = {3,2,1,0,4};
        boolean result = canJump(nums);
        System.out.println(result);
    }

    public static boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        int last = nums.length-1;
        int reach;
        while(start <= end) {
            reach = start+nums[start];
            if(reach >= last) return true;
            end = Math.max(end, reach);
            start++;
        }
        return false;
    }

    /*    public boolean canJump(int[] nums) {
        int start = 0;
        int end = 0;
        int last = nums.length-1;
        while(start <= end) {
            int localMax = end;
            for(int i=start; i<=end; i++) {
                if(i+nums[i] >= last) return true;
                localMax = Math.max(localMax, i+nums[i]);
            }
            start++;
            if(localMax == end) return false;
            end = localMax;
        }
        return false;
    }*/
}
