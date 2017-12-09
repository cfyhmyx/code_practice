//Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

import java.util.ArrayList;
import java.util.List;

public class Leetcode113 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(35);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(32);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<List<Integer>> result = pathSum(n1, 38);
        System.out.println(result);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            helper(root, sum, result, path);
        }
        return result;
    }

    public static void helper(TreeNode current, int sum, List<List<Integer>> result, List<Integer> path) {
        if(current.left == null && current.right == null) {
            if(sum-current.val == 0){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if(current.left != null) {
            path.add(current.left.val);
            helper(current.left, sum - current.val, result, path);
            path.remove(path.size()-1);
        }
        if(current.right != null) {
            path.add(current.right.val);
            helper(current.right, sum - current.val, result, path);
            path.remove(path.size()-1);
        }
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
