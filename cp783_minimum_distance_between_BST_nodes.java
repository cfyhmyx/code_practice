//Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.

import java.util.Stack;

public class Leetcode783 {
    public static void main(String args[]) {

    }

    public int minDiffInBST(TreeNode root) {
        int result = Integer.MAX_VALUE;
        Integer pre = null;
        Stack<TreeNode> s = new Stack<>();
        while(true) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else if(s.empty()) {
                break;
            } else {
                TreeNode visit = s.pop();
                if(pre != null) {
                    result = Math.min(result, visit.val-pre);
                }
                pre = visit.val;
                root = visit.right;
            }
        }
        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
