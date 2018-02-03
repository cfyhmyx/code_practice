//Given a binary tree, determine if it is a valid binary search tree (BST).
//Assume a BST is defined as follows:
//The left subtree of a node contains only nodes with keys less than the node's key.
//The right subtree of a node contains only nodes with keys greater than the node's key.
//Both the left and right subtrees must also be binary search trees.

import java.util.Stack;

public class Leetcode098 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        boolean result = isValidBST(n1);
        System.out.println(result);
    }

    public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return isValidWithBound(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidWithBound(TreeNode root, double low, double high){
        if(root == null) return true;
        if(root.val <= low || root.val >= high) return false;
        return isValidWithBound(root.left, low, root.val) && isValidWithBound(root.right, root.val, high);
    }

    /*public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean isFirst = true;
        int last = 0;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else if (s.empty()){
                break;
            } else {
                TreeNode visit = s.pop();
                if(isFirst || visit.val > last) {
                    last = visit.val;
                    isFirst = false;
                    root = visit.right;
                } else {
                    return false;
                }
            }
        }
        return true;
    }*/

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
