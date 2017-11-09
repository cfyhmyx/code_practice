//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most k transactions.

public class Leetcode188 {
    public static void main(String args[]) {
        int[] nums = {2,5,7,1,4,3,1,3};
        int result = maxProfit(3, nums);
        System.out.println(result);
    }

    public static int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);

        int T[][] = new int[k+1][prices.length];

        for (int i = 1; i < T.length; i++) {
            int maxDiff = Integer.MIN_VALUE;
            for (int j = 1; j < T[0].length; j++) {
                maxDiff = Math.max(maxDiff, T[i-1][j-1] - prices[j-1]);
                T[i][j] = Math.max(T[i][j-1], prices[j] + maxDiff);
            }
        }
        return T[k][prices.length-1];
    }

    private static int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }

}
