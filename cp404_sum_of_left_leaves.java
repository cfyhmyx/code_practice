//Find the sum of all left leaves in a given binary tree.

public class Leetcode404 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        int result = sumOfLeftLeaves(n1);
        System.out.println(result);
    }

    private static int sum = 0;

    public static int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }

    private static void helper(TreeNode root, boolean isLeft) {
        if(root == null) return;
        if(root.left == null && root.right == null && isLeft) {
            sum += root.val;
            return;
        }
        helper(root.left, true);
        helper(root.right, false);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
