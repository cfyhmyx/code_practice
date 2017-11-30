//Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w
//as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

public class Leetcode235 {
    public static void main(String args[]) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
