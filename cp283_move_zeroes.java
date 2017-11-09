//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//Note: You must do this in-place without making a copy of the array. Minimize the total number of operations.

public class Leetcode283 {
    public static void main(String args[]) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for(int num: nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int index = 0;
        for(int num : nums) {
            if(num!=0) {
                nums[index++] = num;
            }
        }
        while(index<nums.length) {
            nums[index++] = 0;
        }
    }

    //better way
    /*public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
    }*/

    //bad way
    /*public static void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for(int i=0; i<nums.length;i++) {
            if(nums[i] == 0 && zeroIndex == -1) {
                zeroIndex = i;
            } else if(nums[i]!=0 && zeroIndex !=-1) {
                nums[zeroIndex] = nums[i];
                nums[i] = 0;
                i = zeroIndex;
                zeroIndex = -1;
            }
        }
    }*/
}
