//Given several boxes with different colors represented by different positive numbers.
//You may experience several rounds to remove boxes until there is no box left.
//Each time you can choose some continuous boxes with the same color (composed of k boxes, k >= 1), remove them and get k*k points.
//Find the maximum points you can get.
public class Leetcode546 {
    public static void main(String args[]) {

    }

    public static int removeBoxes(int[] boxes) {
        int[][][] dp = new int[100][100][100];
        return dfs(boxes, dp, 0, boxes.length-1, 0);
    }

    private static int dfs(int[] boxes, int[][][] dp, int left, int right, int number) {
        if(left > right) return 0;
        if(dp[left][right][number] != 0) return dp[left][right][number];
        //first case
        while(right>left && boxes[right] == boxes[right-1]) {
            right--;
            number++;
        }
        dp[left][right][number] = (number+1)*(number+1) + dfs(boxes, dp, left, right-1, 0);

        //second case
        for(int i=left; i<right; i++) {
            if(boxes[i] == boxes[right]) {
                dp[left][right][number] = Math.max(dp[left][right][number], dfs(boxes, dp, i+1, right-1, 0) + dfs(boxes, dp, left, i, number+1));
            }
        }
        return dp[left][right][number];
    }
}
