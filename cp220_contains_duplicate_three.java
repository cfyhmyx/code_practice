//Given an array of integers, find out whether there are two distinct indices i and j in the array such that
//the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.

import java.util.HashMap;
import java.util.TreeSet;

public class Leetcode220 {
    public static void main(String args[]) {

    }

    //O(n)
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k <= 0 || t < 0) return false;
        HashMap<Long, Long> keyToNum = new HashMap<>();
        long div = (long)t + 1;
        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i];
            long key = num / div;
            if(num < 0) key--;
            if (keyToNum.containsKey(key)
                    || keyToNum.containsKey(key + 1) && keyToNum.get(key + 1) - num <= t
                    || keyToNum.containsKey(key - 1) && num - keyToNum.get(key - 1) <= t)
                return true;
            if (i >= k) keyToNum.remove(((long)nums[i - k]) / div);
            keyToNum.put(key, num);
        }
        return false;
    }

    //O(nlogk)
    /*public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i<nums.length; i++) {
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t ) ||
                    (ceiling != null && ceiling - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }*/

}
