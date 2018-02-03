//Given a binary tree, find its minimum depth.
//The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

public class Leetcode111 {
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

        int result = minDepth(n1);
        System.out.println(result);
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) {
            return Math.max(minDepth(root.left), minDepth(root.right))+1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
