//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

import java.util.HashMap;
import java.util.Map;

public class Leetcode525 {
    public static void main(String args[]) {

    }

    //similar to leetcode560, 523, 001
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;
            else zero--;
            if (zero == 0) max = i + 1;
            if (!map.containsKey(zero)) map.put(zero, i);
                //find the same key means the array between last position and current position has equal number of 0 and 1
            else max = Math.max(max, i - map.get(zero));
        }
        return max;
    }
}
