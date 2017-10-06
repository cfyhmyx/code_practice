//description: https://leetcode.com/problems/combination-sum/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode039 {
    public static void main(String args[]) {
        int[] candidates = {};
        List<List<Integer>> result = combinationSum(candidates, 7);
        for(List<Integer> res : result) {
            System.out.print(res);
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, path, result, 0);
        return result;
    }

    private static void dfs(int[] candidates, int target, List<Integer> path, List<List<Integer>> result, int start) {
        if(target == 0 && path.size() != 0) {
            result.add(new ArrayList<>(path));
        }
        for(int i=start; i<candidates.length; i++) {
            if(target-candidates[i] < 0) break;
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i], path, result, i);
            path.remove(path.size()-1);
        }
    }
}
