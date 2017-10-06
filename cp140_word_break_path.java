//description: https://leetcode.com/problems/word-break-ii/description/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode140 {
    public static void main(String args[]) {

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(wordDict == null || wordDict.isEmpty()) {
            return result;
        }

        if(s == null || s.isEmpty()) {
            result.add("");
            return result;
        }

        int m = s.length();
        boolean[] dp = new boolean[m+1];
        dp[0] =true;

        Set<String> set = new HashSet<>();
        int minLength = m;
        int maxLength = 0;
        for(String word : wordDict) {
            set.add(word);
            minLength = Math.min(word.length(), minLength);
            maxLength = Math.max(word.length(), maxLength);
        }
        for(int end=minLength; end<=m; end++) {
            for(int start=Math.max(0,end-maxLength); start<=end-minLength; start++) {
                if(dp[start] && set.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        dfs(s, set, dp, maxLength, m, "", result);
        return result;
    }

    private static void dfs(String s, Set<String> set, boolean[] dp, int maxLength, int end, String sentence, List<String> result) {
        if(end == 0) {
            sentence = sentence.substring(0, sentence.length()-1);
            result.add(sentence);
            return;
        }
        if(dp[end] == false) {
            return;
        }
        for(int i=1; i<=end; i++) {
            String word = s.substring(end-i, end);
            if(set.contains(word)) {
                dfs(s, set, dp, maxLength, end-i, word+" "+sentence, result);
            }
        }
    }
}
