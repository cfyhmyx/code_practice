//Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode366 {
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
        List<List<Integer>> res = findLeaves(n1);
        System.out.println(res);

    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private static int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }

    /*public static List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        while(root.left !=null || root.right!=null) {
            List<Integer> leaves = new ArrayList<>();
            getLeaves(root, leaves, null, false);
            res.add(leaves);
        }
        res.add(Arrays.asList(root.val));
        return res;
    }

    private static void getLeaves(TreeNode node, List<Integer> leaves, TreeNode pre, boolean isLeftChild) {
        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            if(isLeftChild) {
                pre.left = null;
            } else {
                pre.right = null;
            }
            return;
        }
        if(node.left != null) {
            getLeaves(node.left, leaves, node, true);
        }
        if(node.right != null) {
            getLeaves(node.right, leaves, node, false);
        }
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
