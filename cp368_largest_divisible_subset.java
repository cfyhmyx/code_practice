//Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
//If there are multiple solutions, return any subset is fine.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode368 {
    public static void main(String args[]) {

    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        Arrays.sort(nums);
        int[] count = new int[nums.length];
        int[] pre = new int[nums.length];
        int max = 0;
        int index = -1;
        for(int i=0; i<nums.length; i++) {
            count[i] = 1;
            pre[i] = -1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]%nums[j] == 0) {
                    if(1+count[j]>count[i]) {
                        count[i] = count[j]+1;
                        pre[i] = j;
                    }
                }
            }
            if(count[i]>max) {
                max = count[i];
                index = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(index != -1) {
            res.add(nums[index]);
            index = pre[index];
        }
        return res;
    }
}
