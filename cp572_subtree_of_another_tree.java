//Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s.
//A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

public class Leetcode572 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(1);
        TreeNode n8 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        n6.left = n7;
        n6.right = n8;

        boolean result = isSubtree(n1, n6);
        System.out.println(result);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return helper(s, t) || (s !=null && isSubtree(s.left, t)) || (s!=null && isSubtree(s.right, t));
    }

    private static boolean helper(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        else if(s!=null && t!=null && s.val==t.val) {
            return helper(s.left, t.left) && helper(s.right, t.right);
        } else {
            return false;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
