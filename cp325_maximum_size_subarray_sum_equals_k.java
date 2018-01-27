//Given an array nums and a target value k, find the maximum length of a subarray that sums to k.
//If there isn't one, return 0 instead.

import java.util.HashMap;

public class Leetcode325 {
    public static void main(String args[]) {
        int[] nums = {0,0};
        int result = maxSubArrayLen(nums, 0);
        System.out.println(result);
    }

    //array, hashmap
    public static int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return max;
    }

}
