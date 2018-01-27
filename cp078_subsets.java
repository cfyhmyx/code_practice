//Given a set of distinct integers, nums, return all possible subsets (the power set).
//Note: The solution set must not contain duplicate subsets.

import java.util.ArrayList;
import java.util.List;

public class Leetcode078 {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, result, path, 0);
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int cur) {
        result.add(new ArrayList<>(path));
        for(int i=cur; i<nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
