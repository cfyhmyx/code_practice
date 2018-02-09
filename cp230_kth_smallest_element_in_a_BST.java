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

    //follow up: what if you could modify the BST node's structure?
    public class Solution {
        public int kthSmallest(TreeNode root, int k) {
            TreeNodeWithCount rootWithCount = buildTreeWithCount(root);
            return kthSmallest(rootWithCount, k);
        }

        private TreeNodeWithCount buildTreeWithCount(TreeNode root) {
            if (root == null) return null;
            TreeNodeWithCount rootWithCount = new TreeNodeWithCount(root.val);
            rootWithCount.left = buildTreeWithCount(root.left);
            rootWithCount.right = buildTreeWithCount(root.right);
            if (rootWithCount.left != null) rootWithCount.count += rootWithCount.left.count;
            if (rootWithCount.right != null) rootWithCount.count += rootWithCount.right.count;
            return rootWithCount;
        }

        private int kthSmallest(TreeNodeWithCount rootWithCount, int k) {
            if (k <= 0 || k > rootWithCount.count) return -1;
            if (rootWithCount.left != null) {
                if (rootWithCount.left.count >= k) return kthSmallest(rootWithCount.left, k);
                if (rootWithCount.left.count == k-1) return rootWithCount.val;
                return kthSmallest(rootWithCount.right, k-1-rootWithCount.left.count);
            } else {
                if (k == 1) return rootWithCount.val;
                return kthSmallest(rootWithCount.right, k-1);
            }
        }

        class TreeNodeWithCount {
            int val;
            int count;
            TreeNodeWithCount left;
            TreeNodeWithCount right;
            TreeNodeWithCount(int x) {val = x; count = 1;};
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
