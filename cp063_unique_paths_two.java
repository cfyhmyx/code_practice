//Follow up for "Unique Paths":
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.

public class Leetcode063 {
    public static void main(String args[]) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if(j>0) {
                    res[j] += res[j-1];
                }
            }
        }
        return res[n-1];
    }

}
