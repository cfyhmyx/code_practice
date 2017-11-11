//Given a binary tree, return all duplicate subtrees.
//For each kind of duplicate subtrees, you only need to return the root node of any one of them.
//Two trees are duplicate if they have the same structure with same node values.

import java.util.*;

public class Leetcode652 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        List<TreeNode> result = findDuplicateSubtrees(n1);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i).val);
        }
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        collectTreeNode(result, root, new HashMap<>());
        return result;
    }

    public static String collectTreeNode(List<TreeNode> result, TreeNode root, Map<String, Integer> map) {
        if(root == null) return "X";
        StringBuilder subTree = new StringBuilder();
        String left = collectTreeNode(result, root.left, map);
        String right = collectTreeNode(result,root.right, map);
        subTree.append(root.val).append(',').append(left).append(',').append(right);
        String subString = subTree.toString();
        if(map.getOrDefault(subString, 0) == 1) {
            result.add(root);
        }
        map.put(subString, map.getOrDefault(subString,0)+1);
        return subString;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
