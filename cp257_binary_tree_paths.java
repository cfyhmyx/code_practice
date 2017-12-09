//Given a binary tree, return all root-to-leaf paths.

import java.util.ArrayList;
import java.util.List;

public class Leetcode257 {
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
        n3.left = n6;
        n3.right = n7;
        List<String> result = binaryTreePaths(n1);
        System.out.println(result);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root != null) {
            String path = "" + root.val + "->";
            helper(result, path, root);
        }
        return result;
    }

    private static void helper(List<String> result, String path, TreeNode node) {
        if(node.left == null && node.right == null) {
            result.add(path.substring(0, path.length()-2));
            return;
        }
        if(node.left != null) {
            helper(result, path+node.left.val+"->", node.left);
        }
        if(node.right != null) {
            helper(result, path+node.right.val+"->", node.right);
        }
    }

    //more elegant
    /*public List<String> binaryTreePaths(TreeNode root) {
        List<String> lst = new ArrayList<>();
        if(root==null) return lst;
        dfs(root, lst, new StringBuilder());
        return lst;
    }

    public void dfs(TreeNode node, List<String> lst, StringBuilder sb){
        sb.append(node.val);
        if(node.left == null && node.right==null){
            lst.add(sb.toString());
            return;
        }
        sb.append("->");
        if(node.left!=null) dfs(node.left, lst, new StringBuilder(sb));
        if(node.right!=null) dfs(node.right, lst, new StringBuilder(sb));
    }*/


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
