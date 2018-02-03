//Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.

import java.util.Stack;

public class Leetcode099 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(146);
        TreeNode n2 = new TreeNode(71);
        TreeNode n3 = new TreeNode(55);
        TreeNode n4 = new TreeNode(321);
        TreeNode n5 = new TreeNode(-33);
        TreeNode n6 = new TreeNode(-13);
        TreeNode n7 = new TreeNode(231);
        TreeNode n8 = new TreeNode(399);
        n1.left = n2;
        n1.right = n6;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        n6.left = n7;
        n6.right = n8;

        recoverTree(n1);

    }

    public static void recoverTree(TreeNode root) {
        if(root == null) return;
        TreeNode last = null;
        TreeNode first = null;
        TreeNode second = null;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else if (s.empty()){
                break;
            } else {
                TreeNode visit = s.pop();
                if(last!=null && visit.val < last.val) {
                    if(first == null) {
                        first = last;
                        second = visit;
                    } else {
                        second = visit;
                        break;
                    }
                }
                last = visit;
                root = visit.right;
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        return;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
