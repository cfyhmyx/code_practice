//Given a binary tree, count the number of uni-value subtrees.
//A Uni-value subtree means all nodes of the subtree have the same value.

public class Leetcode250 {
    public static void main(String args[]) {

    }

    private static int result = 0;

    public static int countUnivalSubtrees(TreeNode root) {
        if(root!=null) {
            helper(root);
        }
        return result;
    }

    private static boolean helper(TreeNode root) {
        if(root == null) return true;
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if(left && right) {
            if(root.left != null && root.left.val != root.val) {
                return false;
            }
            if(root.right != null && root.right.val != root.val) {
                return false;
            }
            result++;
            return true;
        }
        return false;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
