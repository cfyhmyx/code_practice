//Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
//Especially, this path can be either increasing or decreasing.
//For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid.
//On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.

public class Leetcode549 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(2);
        /*n1.right = n3;
        n3.left = n2;
        n3.right = n4;
        n4.right = n5;*/
        n2.right = n3;
        n3.left = n6;
        n6.left = n1;
        int result = longestConsecutive(n2);
        System.out.println(result);
    }

    private static int maxlen = 0;

    public static int longestConsecutive(TreeNode root) {
        helper(root);
        return maxlen;
    }

    private static int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int inc = 1, dec = 1;
        int[] left = helper(root.left), right = helper(root.right);
        if (root.left != null) {
            if (root.left.val == root.val+1) inc += left[0];
            if (root.left.val == root.val-1) dec += left[1];
        }
        if (root.right != null) {
            if (root.right.val == root.val+1) inc = Math.max(inc, 1+right[0]);
            if (root.right.val == root.val-1) dec = Math.max(dec, 1+right[1]);
        }
        maxlen = Math.max(inc+dec-1, maxlen);
        return new int[]{inc, dec};
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
