//Given a binary tree, write a function to get the maximum width of the given tree.
//The width of a tree is the maximum width among all levels.
//The binary tree has the same structure as a full binary tree, but some nodes are null.
//The width of one level is defined as the length between the end-nodes
//(the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also
//counted into the length calculation.

import java.util.ArrayList;
import java.util.List;

public class Leetcode662 {
    public static void main(String args[]) {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n0.left = n1;
        n1.right = n2;
        n0.right = n3;
        int result = widthOfBinaryTree(n0);
        System.out.println(result);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        List<Integer> lefts = new ArrayList<Integer>(); // left most nodes at each level;
        return dfs(root, 1, 0, lefts);
    }

    private static int dfs(TreeNode n, int id, int d, List<Integer> lefts) { // d : depth
        if (n == null) return 0;
        if (d >= lefts.size()) lefts.add(id);   // add left most node
        return Math.max(id + 1 - lefts.get(d), Math.max(dfs(n.left, id*2, d+1, lefts), dfs(n.right, id*2+1, d+1, lefts)));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
