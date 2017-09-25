//description: https://leetcode.com/problems/word-break/description/
import java.util.*;

public class Leetcode139 {
    public static void main(String args[]) {

    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s==null || s.length() == 0 || wordDict == null || wordDict.size()==0) {
            return false;
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
        return dp[m];
    }
}
