//Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode637 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(32);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        List<Double> result = averageOfLevels(n1);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int m = q.size();
            double sum = 0;
            for(int i=0; i<m; i++) {
                TreeNode cur = q.poll();
                if(cur.left!=null) {
                    q.add(cur.left);
                }
                if(cur.right!=null) {
                    q.add(cur.right);
                }
                sum += cur.val;
            }
            result.add(sum/m);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
