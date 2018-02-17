//You are given coins of different denominations and a total amount of money amount.
//Write a function to compute the fewest number of coins that you need to make up that amount.
//If that amount of money cannot be made up by any combination of the coins, return -1.

public class Leetcode322 {
    public static void main(String args[]) {
        int[] coins = {186,419,83,408};
        int result = coinChange(coins, 6249);
        System.out.println(result);
    }

    //bottom up
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount+1];
        for(int i=1; i<=amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=0; j<coins.length; j++) {
                if(i>=coins[j] && dp[i-coins[j]] != -1){
                    min = Math.min(min, dp[i-coins[j]]+1);
                }
            }
            dp[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return dp[amount];
    }

    //top down
    /*public static int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        return dfs(coins, amount, new int[amount]);
    }

    public static int dfs(int[] coins, int rem, int[] count) {
        if(rem<0) return -1;
        if(rem==0) return 0;
        if(count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;
        for(int coin:coins) {
            int res = dfs(coins, rem-coin, count);
            if(res>=0 && res<min) {
                min = 1+res;
            }
        }
        count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
        return count[rem-1];
    }*/

}
