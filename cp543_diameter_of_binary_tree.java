//Given a binary tree, you need to compute the length of the diameter of the tree.
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
//This path may or may not pass through the root.

public class Leetcode543 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        int result = diameterOfBinaryTree(n1);
        System.out.println(result);
    }

    private static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter-1;
    }

    private static int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left+right+1);
        return Math.max(left,right)+1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
