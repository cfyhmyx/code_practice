//Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

import java.util.HashMap;
import java.util.Map;

public class Leetcode560 {
    public static void main(String args[]) {
        int[] nums = {0,0,0};
        int result = subarraySum(nums, 0);
        System.out.println(result);
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int num : nums) {
            sum += num;
            result += preSum.getOrDefault(sum - k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

}
