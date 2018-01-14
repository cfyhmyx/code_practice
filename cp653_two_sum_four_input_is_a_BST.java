//Given a Binary Search Tree and a target number, return true if there exist two elements in the BST
//such that their sum is equal to the given target.

import java.util.HashSet;

public class Leetcode653 {
    public static void main(String args[]) {

    }

    public static boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public static boolean dfs(TreeNode root, HashSet<Integer> set, int k){
        if(root == null)return false;
        if(set.contains(k - root.val))return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
