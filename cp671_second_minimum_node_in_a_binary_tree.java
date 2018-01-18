//Given a non-empty special binary tree consisting of nodes with the non-negative value,
//where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
//then this node's value is the smaller value among its two sub-nodes.
//Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
//If no such second minimum value exists, output -1 instead.

public class Leetcode671 {
    public static void main(String args[]) {

    }

    private static int min = Integer.MAX_VALUE;
    private static int min_second = Integer.MAX_VALUE;

    public static int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.val > min_second) return min_second == Integer.MAX_VALUE ? -1 : min_second;
        if(root.val < min) {
            min_second = min;
            min = root.val;
        } else if(root.val > min && root.val <= min_second){
            min_second = root.val;
        }
        findSecondMinimumValue(root.right);
        findSecondMinimumValue(root.left);
        return min_second == Integer.MAX_VALUE ? -1 : min_second;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
