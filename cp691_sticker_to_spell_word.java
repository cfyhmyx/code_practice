//We are given N different types of stickers. Each sticker has a lowercase English word on it.
//You would like to spell out the given target string by cutting individual letters from your collection of stickers and rearranging them.
//You can use each sticker more than once if you want, and you have infinite quantities of each sticker.
//What is the minimum number of stickers that you need to spell out the target? If the task is impossible, return -1.

public class Leetcode691 {
    public static void main(String args[]) {

    }

    public static int minStickers(String[] stickers, String target) {
        int n = target.length(), m = 1 << n; // if target has n chars, there will be m=2^n subset of characters in target
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) dp[i] = Integer.MAX_VALUE; // use index 0 - 2^n as bitmaps to represent each subset of all chars in target
        dp[0] = 0; // first thing we know is : dp[empty set] requires 0 stickers,
        for (int i = 0; i < m; i++) { // for every subset i, start from 000...000
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String s : stickers) { // try use each sticker as an char provider to populate 1 of its superset, to do that:
                int sup = i;
                for (char c : s.toCharArray()) { // for each char in the sticker, try apply it on a missing char in the subset of target
                    for (int r = 0; r < n; r++) {
                        if (target.charAt(r) == c && ((sup >> r) & 1) == 0) {
                            sup |= 1 << r;
                            break;
                        }
                    }
                }
                // after you apply all possible chars in a sticker, you get an superset that take 1 extra sticker than subset
                // would take, so you can try to update the superset's minsticker number with dp[sub]+1;
                dp[sup] = Math.min(dp[sup], dp[i] + 1);
            }
        }
        return dp[m - 1] != Integer.MAX_VALUE ? dp[m - 1] : -1;
    }
}
