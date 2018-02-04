//Given a binary tree, flatten it to a linked list in-place.

public class Leetcode114 {
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

        flatten(n1);
    }


    public static void flatten(TreeNode root) {
        helper(root, null);
    }

    public static TreeNode helper(TreeNode root, TreeNode pre) {
        if(root == null) return pre;
        pre=helper(root.right,pre);
        pre=helper(root.left,pre);
        root.right = pre;
        root.left = null;
        pre = root;
        return pre;
    }

        /*public static void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode dummy = new TreeNode(0);
        TreeNode cur = dummy;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.empty()) {
            TreeNode temp = s.pop();
            cur.right = temp;
            cur = cur.right;
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null) {
                s.push(temp.left);
                cur.left = null;
            }
        }
        return;
    }*/

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
