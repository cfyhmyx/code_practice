//https://leetcode.com/problems/unique-paths/description/

public class Leetcode062 {
    public static void main(String args[]) {

    }

    //O(m*n) time, O(m*n) space
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    //O(m*n) time, O(n) space
    /*public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=1; j<n; j++) {
                res[j] = res[j] + res[j-1];
            }
        }
        return res[n-1];
    }*/

}
