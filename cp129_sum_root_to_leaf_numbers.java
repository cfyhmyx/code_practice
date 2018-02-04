//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//An example is the root-to-leaf path 1->2->3 which represents the number 123. Find the total sum of all root-to-leaf numbers.

public class Leetcode129 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        int result = sumNumbers(n1);
        System.out.println(result);
    }

    private static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private static void helper(TreeNode node, int path) {
        if(node == null) return;
        path = 10*path + node.val;
        if(node.left == null && node.right == null) {
            sum += path;
            return;
        }
        helper(node.left, path);
        helper(node.right, path);
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
