//Given inorder and postorder traversal of a tree, construct the binary tree.

public class Leetcode106 {
    public static void main(String args[]) {
        int[] postorder = {4,5,2,6,7,3,1};
        int[] inorder = {4,2,5,1,6,3,7};

        TreeNode result = buildTree(inorder, postorder);
        System.out.println(result.val);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, postorder.length-1, 0, inorder.length-1,inorder, postorder);
    }

    public static TreeNode helper(int ps, int pe, int is, int ie, int[] inorder, int[] postorder) {
        if(pe < ps || pe < 0) return null;
        TreeNode node = new TreeNode(postorder[pe]);
        int index = -1;
        for (int i=is; i<=ie; i++) {
            if(inorder[i] == postorder[pe]) {
                index = i;
                break;
            }
        }
        int dis = index-is;
        node.left = helper(ps, ps+dis-1, is, index-1, inorder,postorder);
        node.right = helper(ps+dis, pe-1, index+1, ie, inorder, postorder);
        return node;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
