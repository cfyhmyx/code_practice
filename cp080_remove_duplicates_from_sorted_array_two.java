//Follow up for "Remove Duplicates":
//What if duplicates are allowed at most twice? For example, Given sorted array nums = [1,1,1,2,2,3],
//Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
//It doesn't matter what you leave beyond the new length.


public class Leetcode080 {
    public static void main(String args[]) {
        int[] nums = {1,1,1,1,1,2,2,2,3};
        int result = removeDuplicates(nums);
        System.out.println(result);
    }

    //better method
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow-2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }

    /*public static int removeDuplicates(int[] nums) {
        int index = 0;
        if(nums.length == 0) return index;
        int count = 1;
        index = 1;
        int cur = nums[0];
        for(int i=1; i<nums.length; i++) {
            nums[index++] = nums[i];
            if(nums[i] == cur) {
                count++;
                if(count >= 3) {
                    index--;
                }
            } else {
                count = 1;
                cur = nums[i];
            }
        }
        return index;
    }*/
}
