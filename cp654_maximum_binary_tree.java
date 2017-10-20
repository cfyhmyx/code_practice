//Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
//The root is the maximum number in the array.
//The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
//The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
//Construct the maximum tree by the given array and output the root node of this tree.
public class Leetcode654 {
    public static void main(String args[]) {
        int[] nums = {3,2,1,6,0,5};
        TreeNode result = constructMaximumBinaryTree(nums);
        System.out.println(result.val);
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        TreeNode result = buildTree(low, high, nums);
        return result;
    }

    public static TreeNode buildTree(int low, int high, int[] nums) {
        if(low > high) return null;
        int maxNum = nums[low];
        int maxIndex = low;
        for(int i=low+1; i<=high; i++) {
            if(nums[i]>maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        TreeNode treeNode = new TreeNode(maxNum);
        treeNode.left = buildTree(low, maxIndex-1, nums);
        treeNode.right = buildTree(maxIndex+1, high, nums);
        return treeNode;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
