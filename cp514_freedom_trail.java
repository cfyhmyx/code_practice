//https://leetcode.com/problems/freedom-trail/description/

import java.util.ArrayList;

public class Leetcode514 {
    public static void main(String args[]) {

    }

    //dp[i][j], the minimum step of starting from ith character from key, and jth ring character is in the 12:00 direction
    public int findRotateSteps(String ring, String key) {
        int m = key.length();
        int n = ring.length();
        int[][] dp = new int[m][n];
        ArrayList<Integer>[] index = new ArrayList[26];
        for(int i=0; i<26; i++) {
            index[i] = new ArrayList<>();
        }
        for(int i=0; i<ring.length(); i++) {
            index[ring.charAt(i)-'a'].add(i);
        }
        return helper(key, 0, ring, 0, index, dp);
    }

    private int helper(String key, int x, String ring, int y, ArrayList<Integer>[] index, int[][] dp) {
        if(x == key.length()) return 0;
        if(dp[x][y] > 0) return dp[x][y];
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> cur = index[key.charAt(x)-'a'];
        for(int i=0; i<cur.size(); i++) {
            int diff = Math.abs(y-cur.get(i));
            int step = Math.min(diff, ring.length()-diff);
            res = Math.min(res, step + helper(key,x+1, ring, cur.get(i), index, dp));
        }
        dp[x][y] = res+1;
        return dp[x][y];
    }
}
