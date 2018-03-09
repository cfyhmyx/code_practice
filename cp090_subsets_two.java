//Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//Note: The solution set must not contain duplicate subsets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode090 {
    public static void main(String args[]) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, result, path, 0);
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> path, int cur) {
        result.add(new ArrayList<>(path));
        for(int i=cur; i<nums.length; i++) {
            if(i>cur && nums[i] == nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums, result, path, i+1);
            path.remove(path.size()-1);
        }
    }
}
