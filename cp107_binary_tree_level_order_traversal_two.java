//Given a binary tree, return the bottom-up level order traversal of its nodes' values.
//(ie, from left to right, level by level from leaf to root).

import java.util.ArrayList;
import java.util.List;

public class Leetcode107 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(32);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<List<Integer>> result = levelOrderBottom(n1);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, result, 0);
        return result;
    }

    public static void helper(TreeNode root, List<List<Integer>> result, int height) {
        if(root == null) return;
        if(height >= result.size()) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size()-height-1).add(root.val);
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
