//Given a 2D board and a word, find if the word exists in the grid.
//The word can be constructed from letters of sequentially adjacent cell,
//where "adjacent" cells are those horizontally or vertically neighboring.
//The same letter cell may not be used more than once.


public class Leetcode079 {
    public static void main(String args[]) {
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean result = exist(board, "ABCESEEEFS");
        System.out.println(result);
    }

    public static boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(helper(board, word, i, j, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, int row, int col, int cur, boolean[][] visited) {
        if(cur == word.length()) {
            return true;
        }
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] != word.charAt(cur) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean result = helper(board,word,row+1,col,cur+1,visited)||helper(board,word,row-1,col,cur+1,visited)
                ||helper(board,word,row,col+1,cur+1,visited)||helper(board,word,row,col-1,cur+1,visited);
        visited[row][col] = false;
        return result;
    }
}
