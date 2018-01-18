//Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
//You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
//How would you optimize the kthSmallest routine?

import java.util.Stack;

public class Leetcode230 {
    public static void main(String args[]) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.add(root);
                root = root.left;
            } else if(s.isEmpty()) {
                break;
            } else {
                root = s.pop();
                count++;
                if(count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
