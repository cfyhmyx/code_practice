//Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {
    public static void main(String args[]) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public static void helper(TreeNode root, List<List<Integer>> result, int height) {
        if(root == null) return;
        if(height >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(height).add(root.val);
        helper(root.left, result, height+1);
        helper(root.right, result, height+1);
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
