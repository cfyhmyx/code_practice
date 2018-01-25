//description: https://leetcode.com/problems/heaters/description/

public class Leetcode474 {
    public static void main(String args[]) {
        String[] strs = {"10","0","1"};
        int res = findMaxForm(strs, 1, 1);
        System.out.println(res);
    }

    //faster and concise
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0, ones = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') zeros++;
                else ones++;
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    //original 0/1 knapsack
    /*public static int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=1; i<=strs.length; i++) {
            for(int j=0; j<=m; j++) {
                for(int k=0; k<=n; k++) {
                    int[] curNum = getOneZeroNum(strs[i-1]);
                    if(j>=curNum[0]&&k>=curNum[1]) {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], 1+dp[i-1][j-curNum[0]][k-curNum[1]]);
                    } else {
                        dp[i][j][k] = dp[i-1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    private static int[] getOneZeroNum(String str) {
        int[] res = new int[2];
        for (char ch : str.toCharArray()) {
            if(ch == '0') {
                res[0]++;
            } else if(ch == '1') {
                res[1]++;
            }
        }
        return res;
    }*/
}
