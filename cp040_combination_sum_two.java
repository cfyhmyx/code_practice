//description: https://leetcode.com/problems/combination-sum-ii/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode040 {
    public static void main(String args[]) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum2(candidates, 8);
        for(List<Integer> res : result) {
            System.out.print(res);
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, path, result, 0);
        return result;
    }

    private static void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> result, int start) {
        if(target == 0 && path.size() != 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start; i<candidates.length; i++) {
            if(target-candidates[i] < 0) return;
            if(i>start && candidates[i] == candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i], path, result, i+1);
            path.remove(path.size()-1);
        }
    }
}
