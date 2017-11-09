//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like
//(ie, buy one and sell one share of the stock multiple times).
//However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).


public class Leetcode122 {
    public static void main(String args[]) {
        int[] nums = {7,1,5,3,6,4};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int result = 0;
        if(prices.length == 0) return result;
        int hold = prices[0];
        for(int price : prices) {
            if(price > hold) {
                result += price-hold;
            }
            hold = price;
        }
        return result;
    }

}
