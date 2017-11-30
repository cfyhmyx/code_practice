//Given a binary tree, find the length of the longest consecutive sequence path.
//The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
//The longest consecutive path need to be from parent to child (cannot be the reverse).

public class Leetcode298 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(2);
        /*n1.right = n3;
        n3.left = n2;
        n3.right = n4;
        n4.right = n5;*/
        n2.right = n3;
        n3.left = n6;
        n6.left = n1;
        int result = longestConsecutive(n2);
        System.out.println(result);
    }

    public static int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0, root.val);
    }

    public static int dfs(TreeNode root, int seq, int target){
        if (root == null) return seq;
        if (root.val == target) seq++;
        else seq =1;
        int left = dfs(root.left, seq, root.val+1);
        int right = dfs(root.right, seq, root.val+1);
        return Math.max(seq,Math.max(left,right));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
