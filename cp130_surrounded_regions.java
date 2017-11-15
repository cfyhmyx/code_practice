//Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//A region is captured by flipping all 'O's into 'X's in that surrounded region.

public class Leetcode130 {
    public static void main(String args[]) {
        char[][] grid = {{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve(grid);
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    public static void solve(char[][] board) {
        int m = board.length;
        if(m==0) return;
        int n = board[0].length;
        for(int i=0; i<n; i++) {
            helper(0, i, m, n, board);
            helper(m-1, i, m, n, board);
        }
        for(int j=1; j<m-1; j++) {
            helper(j, 0, m, n, board);
            helper(j, n-1, m, n, board);
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private static void helper(int row, int col, int m, int n, char[][] board) {
        if(row<0 || col<0 || row>=m || col>=n || board[row][col] != 'O') return;
        board[row][col] = 'A';
        helper(row+1, col, m, n, board);
        helper(row-1, col, m, n, board);
        helper(row, col+1, m, n, board);
        helper(row, col-1, m, n, board);
    }

}
