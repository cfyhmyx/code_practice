//description: https://leetcode.com/problems/combination-sum-iv/description/
//explanation: https://discuss.leetcode.com/topic/52302/1ms-java-dp-solution-with-detailed-explanation/2?page=1
import java.util.Arrays;

public class Leetcode377 {
    public static void main(String args[]) {
        int[] candidates = {1, 2, 3};
        int result = combinationSum4(candidates, 32);
        System.out.println(result);
    }


    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper(nums, target, dp);
    }

    private static int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += helper(nums, target - nums[i], dp);
            }
        }
        dp[target] = res;
        return res;
    }
}

//recursion: much slower
/*class Solution {

    private int total = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        dfs(nums, target);
        return total;
    }

    private void dfs(int[] candidates, int target) {
        if(target == 0) {
            total++;
            return;
        }
        for(int i=0; i<candidates.length; i++) {
            if(target-candidates[i] < 0) return;
            dfs(candidates,target-candidates[i]);
        }
    }
}*/

//bottom to up dp: slower
/*public int combinationSum4(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
        for (int j = 0; j < nums.length; j++) {
            if (i - nums[j] >= 0) {
                comb[i] += comb[i - nums[j]];
            }
        }
    }
    return comb[target];
}*/