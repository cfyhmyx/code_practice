//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete at most two transactions.

public class Leetcode123 {
    public static void main(String args[]) {
        int[] nums = {2,1,2,0,1};
        int result = maxProfit(nums);
        System.out.println(result);
    }

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MAX_VALUE;
        //profit after buy/sell
        int afterFirstSell = 0;
        int afterSecondBuy = Integer.MIN_VALUE;
        int afterSecondSell = 0;
        for (int curPrice : prices) {
            firstBuy = Math.min(firstBuy, curPrice); //for first buy price ,the lower,the better
            afterFirstSell = Math.max(afterFirstSell ,curPrice-firstBuy); // the profit after first sell ,the higher,the better
            afterSecondBuy = Math.max(afterSecondBuy ,afterFirstSell - curPrice);//the profit left after second buy,the higher,the better
            afterSecondSell = Math.max(afterSecondSell ,afterSecondBuy + curPrice); // the profit left after second sell ,the higher,the better
        }
        return afterSecondSell ; // afterSecondSell will be the max profit ultimately
    }

    /*public static int maxProfit(int[] prices) {
        int m = prices.length;
        if(m < 2 ) return 0;
        int[] left = new int[m];
        int[] right = new int[m];
        int hold = prices[0];
        for(int i=1; i<m; i++) {
            if(prices[i]>hold) {
                left[i] = Math.max(left[i-1], prices[i]-hold);
            } else {
                hold = prices[i];
                left[i] = left[i-1];
            }
        }
        int sell = prices[m-1];
        for(int i=m-2; i>0; i--) {
            if(prices[i]<sell) {
                right[i] = Math.max(right[i+1],sell-prices[i]);
            }  else {
                sell = prices[i];
                right[i] = right[i+1];
            }
        }
        int result = 0;
        for(int i=0; i<m; i++) {
            result = Math.max(result, left[i]+right[i]);
        }
        return result;
    }*/

}
