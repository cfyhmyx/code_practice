//Given a binary tree where all the right nodes are either leaf nodes with
//a sibling (a left node that shares the same parent node) or empty,
//flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes.
//Return the new root.

import java.util.Stack;

public class Leetcode156 {
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

        TreeNode result = upsideDownBinaryTree(n1);
        System.out.println(result.val);
    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        while(root != null) {
            s.add(root);
            root = root.left;
        }
        if(s.isEmpty()) return null;
        TreeNode newRoot = s.pop();
        TreeNode nextRoot = newRoot;
        while(!s.isEmpty()) {
            TreeNode temp = s.pop();
            nextRoot.right = temp;
            nextRoot.left = temp.right;
            nextRoot = temp;
            nextRoot.left = null;
            nextRoot.right = null;
        }
        return newRoot;
    }

    //better method
    /*public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode next = null;
        TreeNode temp = null;
        TreeNode prev = null;

        while(curr != null) {
            next = curr.left;

            // swapping nodes now, need temp to keep the previous right child
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }*/

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
