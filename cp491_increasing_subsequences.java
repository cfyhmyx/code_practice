//Given an integer array,your task is to find all the different possible increasing subsequences of the given array,
//and the length of an increasing subsequence should be at least 2 .
import java.util.*;
public class Leetcode491 {
    public static void main(String args[]) {
        int[] nums  = {1,2,1,1};
        List<List<Integer>> result = findSubsequences(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, result, 0, path);
        return result;
    }

    public static void dfs(int[] nums, List<List<Integer>> setResult, int start, List<Integer> path) {
        if(path.size()>=2) {
            setResult.add(new ArrayList<>(path));
        }
        for(int i=start; i<nums.length; i++) {
            if(!isDuplicated(nums, start, i) && (path.isEmpty() || path.get(path.size()-1) <= nums[i])) {
                path.add(nums[i]);
                dfs(nums, setResult, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public static boolean isDuplicated(int[] nums, int start, int end) {
        for(int i=start; i<end; i++) {
            if(nums[i] == nums[end])
                return true;
        }
        return false;
    }

// use hashset
/*    public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> setResult = new HashSet<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, setResult, 0, path);
        List<List<Integer>> result = new ArrayList<>(setResult);
        return result;
    }

    public static void dfs(int[] nums, Set<List<Integer>> setResult, int start, List<Integer> path) {
        if(path.size()>=2) {
            setResult.add(new ArrayList<>(path));
        }
        for(int i=start; i<nums.length; i++) {
            if(path.isEmpty() || path.get(path.size()-1) <= nums[i]) {
                path.add(nums[i]);
                dfs(nums, setResult, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }*/
}
