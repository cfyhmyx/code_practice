//description: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

import java.util.ArrayList;
import java.util.List;

public class Leetcode77 {
    public static void main(String args[]) {
        List<List<Integer>> result = combine(4, 2);
        for(List<Integer> res : result) {
            System.out.print(res);
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(n, k, path, result, 1);
        return result;
    }

    private static void dfs(int n, int k, List<Integer> path, List<List<Integer>> result, int cur) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int i=cur; i<=n; i++) {
            path.add(i);
            dfs(n, k, path, result, i+1);
            path.remove(path.size()-1);
        }
    }

}
