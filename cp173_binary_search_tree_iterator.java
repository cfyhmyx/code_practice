//Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
//Calling next() will return the next smallest number in the BST.
//Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
import java.util.Stack;

public class Leetcode173 {
    public static void main(String args[]) {

    }

    public static class BSTIterator {

        private Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            pushAll(root);
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode cur = stack.pop();
            pushAll(cur.right);
            return cur.val;
        }

        private void pushAll(TreeNode node) {
            for(; node!=null; stack.push(node), node=node.left);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
