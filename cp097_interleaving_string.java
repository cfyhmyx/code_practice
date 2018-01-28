//Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

public class Leetcode097 {
    public static void main(String args[]) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        boolean result = isInterleave(s1, s2, s3);
        System.out.println(result);
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int l = s3.length();
        if (m+n != l) return false;
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int i=1; i<=m; i++) {
            if(s3.charAt(i-1) == s1.charAt(i-1)){
                dp[i][0] = true;
            } else {
                break;
            }
        }

        for(int j=1; j<=n; j++) {
            if(s3.charAt(j-1) == s2.charAt(j-1)) {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1) || dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        return dp[m][n];
    }

}
