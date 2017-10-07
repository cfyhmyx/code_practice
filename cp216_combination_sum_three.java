//description: https://leetcode.com/problems/combination-sum/description/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode216 {
    public static void main(String args[]) {
        List<List<Integer>> result = combinationSum3(3, 15);
        for(List<Integer> res : result) {
            System.out.print(res);
            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, result, 1);
        return result;
    }

    public static void dfs(int n, int k, List<Integer> path, List<List<Integer>> result, int start) {
        if(n==0 && k==0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=start; i<=9; i++) {
            if(n-i<0 || k<=0) return;
            path.add(i);
            dfs(n-i, k-1, path, result, i+1);
            path.remove(path.size()-1);
        }
    }
}
