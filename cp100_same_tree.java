//Given two binary trees, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

public class Leetcode100 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(34);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n4.right = n6;
        n4.left = n5;

        boolean result = isSameTree(n1, n4);
        System.out.println(result);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        else if (p == null || q==null || p.val != q.val) return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
