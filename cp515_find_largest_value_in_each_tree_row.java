//You need to find the largest value in each row of a binary tree.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode515 {
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
        n3.left = n7;
        n3.right = n6;
        List<Integer> res = largestValues(n1);
        System.out.println(res);

    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i=0; i<n; i++) {
                TreeNode cur = queue.poll();
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
                max = Math.max(max,cur.val);
            }
            res.add(max);
        }
        return res;
    }

    //recursion
    /*public List<Integer> largestValues(TreeNode root) {
    List<Integer> returnVal = new ArrayList<>();
    largestValue(root, returnVal, 0);
        return returnVal;
}

    private void largestValue(TreeNode root, List<Integer> returnVal, int depth) {
        if (root == null) {
            return;
        }

        if (returnVal.size() > depth) {
            returnVal.set(depth, Math.max(root.val, returnVal.get(depth)));
        } else {
            returnVal.add(root.val);
        }
        largestValue(root.left, returnVal, depth+1);
        largestValue(root.right, returnVal, depth+1);
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
