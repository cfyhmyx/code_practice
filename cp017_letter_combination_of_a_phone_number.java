//Given a digit string, return all possible letter combinations that the number could represent.
//A mapping of digit to letters (just like on the telephone buttons) is given below.

import java.util.ArrayList;
import java.util.List;

public class Leetcode017 {
    public static void main(String args[]) {
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }

    private static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits  != null && digits.length()>0) {
            dfs(digits, result, "", 0);
        }
        return result;
    }

    private static void dfs(String digits, List<String> result, String path, int cur) {
        if(path.length() == digits.length()) {
            result.add(path);
            return;
        }
        for(int i=0; i<arr[digits.charAt(cur)-'0'].length(); i++) {
            dfs(digits, result, path+arr[digits.charAt(cur)-'0'].charAt(i), cur+1);
        }
    }

}
