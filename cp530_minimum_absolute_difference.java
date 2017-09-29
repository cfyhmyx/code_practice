//Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
import java.util.Stack;
public class Leetcode530 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(18);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(66);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(50);
        TreeNode n7 = new TreeNode(77);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        int result = getMinimumDifference(n1);
        System.out.println(result);
    }

    public static int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        int dif = Integer.MAX_VALUE;
        int pre = -1;
        while(true) {
            if(root != null) {
                s.push(root);
                root = root.left;
            } else if(!s.empty()) {
                root = s.pop();
                if(pre != -1) {
                    dif = Math.min(dif, root.val - pre);
                }
                pre = root.val;
                root = root.right;
            } else {
                break;
            }
        }
        return dif;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
