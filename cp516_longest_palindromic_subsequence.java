//Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

public class Leetcode516 {
    public static void main(String args[]) {
        int result = longestPalindromeSubseq("babad");
        System.out.println(result);
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
        }
        for(int length = 1; length < n; length++) {
            for(int i=0; i<n-length; i++) {
                int j = i+length;
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }

}
