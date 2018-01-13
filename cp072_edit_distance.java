//Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
//You have the following 3 operations permitted on a word:
//a) Insert a character
//b) Delete a character
//c) Replace a character

public class Leetcode072 {
    public static void main(String args[]) {
        int result = minDistance("st", "seat" );
        System.out.println(result);
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++) {
            dp[i][0] = i;
        }
        for(int j=1; j<=n; j++) {
            dp[0][j] = j;
        }
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int replace = dp[i-1][j-1] + 1;
                    int delete = dp[i-1][j] + 1;
                    int insert = dp[i][j-1] + 1;
                    dp[i][j] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return dp[m][n];
    }
}
