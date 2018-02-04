//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return all possible palindrome partitioning of s.

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {
    public static void main(String args[]) {

    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0) return res;
        helper(res, new ArrayList<>(), s);
        return res;
    }

    private static void helper(List<List<String>> res, List<String> path, String s) {
        if(s.length() == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0; i<s.length(); i++) {
            if(isPalindrome(s.substring(0, i+1))) {
                path.add(s.substring(0, i+1));
                helper(res, path, s.substring(i+1));
                path.remove(path.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        for(int i=0; i<s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

}
