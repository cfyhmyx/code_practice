//Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
//Formally the function should: Return true if there exists i, j, k
//such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
//Your algorithm should run in O(n) time complexity and O(1) space complexity.

public class Leetcode334 {
    public static void main(String args[]) {
        int[] nums = {2,4,-2,-3};
        boolean result = increasingTriplet(nums);
        System.out.println(result);
    }

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= num1) {
                num1 = num;
            } else if(num <= num2) {
                num2 = num;
            } else {
                return true;
            }
        }
        return false;
    }

}
