//We are playing the Guess Game. The game is as follows:
//I pick a number from 1 to n. You have to guess which number I picked.
//Every time you guess wrong, I'll tell you whether the number is higher or lower.
//However, when you guess a particular number x, and you guess wrong, you pay $x.
//You win the game when you guess the number I picked.
//Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

//explaination: traverse each element from 1 to n. For each element, by using binary search, it could either go down or go up,
//then we could get two costs. Select the higher cost as the guaranteed cost to win.
//Then find all the guaranteed cost to get the min value.

public class Leetcode375 {
    public static void main(String args[]) {

    }

    static int[][] dp;

    public static int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return getMoneyAmount(1, n);
    }

    private static int getMoneyAmount(int lower, int upper) {
        if (lower >= upper) {
            return 0;
        }
        if (dp[lower][upper] != 0) {
            return dp[lower][upper];
        }
        int maximum = Integer.MAX_VALUE;
        for (int i = lower; i <= upper; i++) {
            maximum = Math.min(maximum, Math.max(getMoneyAmount(lower, i-1), getMoneyAmount(i+1, upper)) + i);
        }
        dp[lower][upper] = maximum;
        return maximum;
    }

}
