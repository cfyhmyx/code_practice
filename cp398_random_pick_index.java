//Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
//The array size can be very large. Solution that uses too much extra space will not pass the judge.

import java.util.*;

public class Leetcode398 {
    public static void main(String args[]) {
        int[] nums = {1,3,1,2,1};
        Solution sol = new Solution(nums);
        int result = sol.pick(1);
        System.out.println(result);
    }


    //assume if we have 3 duplicates:
    //the possibility of picking the first one is: 1(pick)*1/2(replace)*(2/3)(replace)=1/3;
    //the possibility of picking the second one is: (1/2)(pick)*(2/3)(replace)=1/3;
    //the possibility of picking the third one is: (1/3)(pick)=1/3.
    static class Solution {

        Random random;
        int[] nums;

        public Solution(int[] nums) {
            random = new Random();
            this.nums = nums;
        }

        public int pick(int target) {
            int result = -1;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != target)
                    continue;
                if (random.nextInt(++count) == 0)
                    result = i;
            }

            return result;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

}
