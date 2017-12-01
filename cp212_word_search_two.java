//Given a 2D board and a list of words from the dictionary, find all words in the board.
//Each word must be constructed from letters of sequentially adjacent cell,
//where "adjacent" cells are those horizontally or vertically neighboring.
//The same letter cell may not be used more than once in a word.

import java.util.ArrayList;
import java.util.List;

public class Leetcode212 {
    public static void main(String args[]) {
    }

    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                helper(board, i, j, root, res);
            }
        }
        return res;
    }

    private static void helper(char[][] board, int row, int col, TrieNode node, List<String> res){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || board[row][col] == '#' || node.next[board[row][col]-'a']==null) {
            return;
        }
        node = node.next[board[row][col]-'a'];
        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        helper(board, row+1, col, node, res);
        helper(board, row-1, col, node, res);
        helper(board, row, col+1, node, res);
        helper(board, row, col-1, node, res);
        board[row][col] = temp;
    }

    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words) {
            TrieNode node = root;
            for(char c : word.toCharArray()) {
                int index = c-'a';
                if(node.next[index] == null) {
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
            }
            node.word = word;
        }
        return root;
    }

    public static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
