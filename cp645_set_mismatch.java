//The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
// one of the numbers in the set got duplicated to another number in the set,
// which results in repetition of one number and loss of another number.
//Given an array nums representing the data status of this set after the error.
// Your task is to firstly find the number occurs twice and then find the number that is missing.
// Return them in the form of an array.
//The given array size will in the range [2, 10000].
//The given array's numbers won't have any order.

public class Leetcode645 {
    public static void main(String args[]) {
        int[] nums = {5,4,3,3,1};
        int[] result = findErrorNums(nums);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        //use number as a position to locate element
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;
        }
        return res;
    }
}
