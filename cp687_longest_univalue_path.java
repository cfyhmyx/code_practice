//Given a binary tree, find the length of the longest path where each node in the path has the same value.
//This path may or may not pass through the root.

public class Leetcode687 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(35);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        int result = longestUnivaluePath(n1);
        System.out.println(result);
    }

    private static int len = 0;

    public static int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        len = 0;
        getLen(root, root.val);
        return len;
    }

    private static int getLen(TreeNode node, int val) {
        if (node == null) return 0;
        int left = getLen(node.left, node.val);
        int right = getLen(node.right, node.val);
        len = Math.max(len, left + right);
        if (val == node.val)  return Math.max(left, right) + 1;
        return 0;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
