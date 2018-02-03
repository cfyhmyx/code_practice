//Given preorder and inorder traversal of a tree, construct the binary tree.

public class Leetcode105 {
    public static void main(String args[]) {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};

        TreeNode result = buildTree(preorder, inorder);
        System.out.println(result.val);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, preorder.length-1, 0, inorder.length-1, preorder, inorder);
    }

    public static TreeNode helper(int ps, int pe, int is, int ie, int[] preorder, int[] inorder) {
        if(pe < ps) return null;
        TreeNode node = new TreeNode(preorder[ps]);
        int index = -1;
        for (int i=is; i<=ie; i++) {
            if(inorder[i] == preorder[ps]) {
                index = i;
                break;
            }
        }
        int dis = index-is;
        node.left = helper(ps+1, ps+dis, is, index-1, preorder,inorder);
        node.right = helper(ps+dis+1, pe, index+1, ie, preorder, inorder);
        return node;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
