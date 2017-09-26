//Given a binary tree, imagine yourself standing on the right side of it,
//return the values of the nodes you can see ordered from top to bottom.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode199 {
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
        List<Integer> result = rightSideView(n1);
        System.out.println(result);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int m = q.size();
            for(int i=0; i<m; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
                if(i==m-1) {
                    result.add(cur.val);
                }
            }
        }
        return result;
    }

    //dfs
    /*public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root, int h) {
        if(root == null) {
            return;
        }
        if(h >= res.size()) {
            res.add(root.val);
        }
        dfs(res, root.right, h+1);
        dfs(res, root.left, h+1);
    }*/


    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
