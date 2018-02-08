//Given a complete binary tree, count the number of nodes.

public class Leetcode222 {
    public static void main(String args[]) {

    }

    public static int countNodes(TreeNode root) {
        int left = helper(root, true);
        int right = helper(root, false);
        if(left == right) {
            return (1<<left)-1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private static int helper(TreeNode root, boolean isLeft) {
        if(root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1 : helper(root.right, isLeft) + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
