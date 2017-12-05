//https://leetcode.com/problems/decode-ways/description/

public class Leetcode091 {
    public static void main(String args[]) {
        int result = numDecodings("1253410");
        System.out.println(result);
    }

    public static int numDecodings(String s) {
        int n = s.length();
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            if (i >= 2 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) - '0' <= 6))) {
                if(s.charAt(i-1) == '0') {
                    dp[i] = dp[i-2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else if(s.charAt(i-1) == '0') {
                return 0;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }
}
