//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.ArrayList;
import java.util.List;

public class Leetcode022 {
    public static void main(String args[]) {
        List<String> result = generateParenthesis(3);
        System.out.println(result);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, "", 0, 0, n);
        return result;
    }

    public static void dfs(List<String> result, String path, int open, int close, int num) {
        if(path.length() == 2*num) {
            result.add(path);
            return;
        }

        if(open < num) {
            dfs(result, path+'(', open+1, close, num);
        }

        if(close < open) {
            dfs(result, path+')', open, close+1, num);
        }
    }

    
}
