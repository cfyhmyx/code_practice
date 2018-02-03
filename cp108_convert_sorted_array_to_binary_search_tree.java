//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
//the two subtrees of every node never differ by more than 1.

public class Leetcode108 {
    public static void main(String args[]) {
        int[] nums = {1,2,3,4,5,6,7};

        TreeNode result = sortedArrayToBST(nums);
        System.out.println(result.val);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int low = 0;
        int high = nums.length;
        TreeNode result = helper(nums, low, high);
        return result;
    }

    public static TreeNode helper(int[] nums, int low, int high) {
        if(low>=high) return null;
        int mid = low + (high-low)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, low, mid);
        node.right = helper(nums, mid+1, high);
        return node;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
