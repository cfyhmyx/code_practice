//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like
//(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

//explaination: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/

public class Leetcode309 {
    public static void main(String args[]) {
        int[] nums = {2,5,7,1,4,3,1,3};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }

}
