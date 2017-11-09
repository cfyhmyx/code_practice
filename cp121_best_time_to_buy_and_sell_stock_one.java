//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
//design an algorithm to find the maximum profit.


public class Leetcode121 {
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
                result = Math.max(result, price-hold);
            } else {
                hold = price;
            }
        }
        return result;
    }

}
