//Given a string S and a string T, count the number of distinct subsequences of S which equals T.
//A subsequence of a string is a new string which is formed from the original string by deleting
//some (can be none) of the characters without disturbing the relative positions of the remaining characters.
//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

public class Leetcode115 {
    public static void main(String args[]) {
        String s = "acdabefbc";
        String t = "ab";
        int result = numDistinct(s, t);
        System.out.println(result);
    }

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
