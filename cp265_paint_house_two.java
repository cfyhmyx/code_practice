//There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
//The cost of painting each house with a certain color is different.
//You have to paint all the houses such that no two adjacent houses have the same color.
//The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
//For example, costs[0][0] is the cost of painting house 0 with color red;
//costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

public class Leetcode265 {
    public static void main(String args[]) {

    }

    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;

        int n = costs.length, k = costs[0].length;
        // min1 is the index of the 1st-smallest cost till previous house
        // min2 is the index of the 2nd-smallest cost till previous house
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            int last1 = min1, last2 = min2;
            min1 = -1; min2 = -1;

            for (int j = 0; j < k; j++) {
                if (j != last1) {
                    // current color j is different to last min1
                    costs[i][j] += last1 < 0 ? 0 : costs[i - 1][last1];
                } else {
                    costs[i][j] += last2 < 0 ? 0 : costs[i - 1][last2];
                }

                // find the indices of 1st and 2nd smallest cost of painting current house i
                if (min1 < 0 || costs[i][j] < costs[i][min1]) {
                    min2 = min1; min1 = j;
                } else if (min2 < 0 || costs[i][j] < costs[i][min2]) {
                    min2 = j;
                }
            }
        }

        return costs[n - 1][min1];
    }

}
