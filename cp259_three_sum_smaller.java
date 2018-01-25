//Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n
//that satisfy the condition nums[i] + nums[j] + nums[k] < target.
//For example, given nums = [-2, 0, 1, 3], and target = 2.
//Return 2. Because there are two triplets which sums are less than 2.

import java.util.Arrays;

public class Leetcode259 {
    public static void main(String args[]) {

    }

    public static int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        if(nums.length<3) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            int low = i+1;
            int high = nums.length-1;
            while(low<high) {
                if(nums[i]+nums[low]+nums[high]<target){
                    res += high-low;
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }

}
