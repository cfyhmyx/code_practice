//Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

public class Leetcode268 {
    public static void main(String args[]) {

    }

    public int missingNumber(int[] nums) {
        if(nums.length == 0) return 0;
        for(int i=0; i<nums.length; i++) {
            while(nums[i] != i && nums[i] < nums.length) {
                int j = nums[i];
                swap(nums, i, j);
            }
        }
        int res = 0;
        for(; res < nums.length; res++) {
            if(nums[res] != res) break;
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*public int missingNumber(int[] nums) {
        int total = 0;
        for(int i = 1; i <= nums.length ;i++ ){
            total += i;
        }
        for(int n : nums){
            total -= n;
        }
        return total;
    }*/
}
