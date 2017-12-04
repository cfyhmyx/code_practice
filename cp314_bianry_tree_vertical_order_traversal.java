//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
//If two nodes are in the same row and column, the order should be from left to right.

import java.util.*;

public class Leetcode314 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(32);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<List<Integer>> result = verticalOrder(null);
        System.out.println(result);
    }

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Map<Integer,List<Integer>> colNode = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        if (root != null) q.offer(new Pair(0, root));
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!colNode.containsKey(p.col))
                colNode.put(p.col, new ArrayList<>());
            colNode.get(p.col).add(p.node.val);
            min = Math.min(min, p.col);
            max = Math.max(max, p.col);

            if (p.node.left != null) q.offer(new Pair(p.col - 1, p.node.left));
            if (p.node.right != null) q.offer(new Pair(p.col + 1, p.node.right));
        }
        for (int i = min; i <= max; i++) result.add(colNode.get(i));
        return result;
    }

    static class Pair{
        TreeNode node;
        int col;
        public Pair(int col, TreeNode node) {
            this.node = node;
            this.col = col;
        }
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
