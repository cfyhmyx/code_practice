//Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
//You may assume each number in the sequence is unique.

import java.util.Stack;

public class Leetcode255 {
    public static void main(String args[]) {
        int[] preorder = {2,1};
        boolean result = verifyPreorder(preorder);
        System.out.println(result);
    }

    //constant space
    public static boolean verifyPreorder(int[] preorder) {
        int i = -1;
        int low = Integer.MIN_VALUE;
        for(int n : preorder){
            if(n < low) return false;
            while(i >= 0 && n > preorder[i]) low = preorder[i--];
            preorder[++i] = n;

        }
        return true;
    }


    //stack
    /*public boolean verifyPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        while (i < preorder.length) {
            if (stack.isEmpty() || preorder[i] < stack.peek()) {
                if (preorder[i] < max) {
                    return false;
                }
                stack.push(preorder[i]);
                i++;
            } else {
                max = stack.pop();
            }
        }
        return true;
    }*/


    //recursion
    /*public static boolean verifyPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }

    private static boolean helper(int[] preorder, int low, int high) {
        if(low >= high) return true;
        int root = preorder[low];
        int i = low+1;
        for(; i<=high; i++) {
            if(preorder[i] > root) {
                break;
            }
        }
        int j=i+1;
        for(; j<=high; j++) {
            if(preorder[j] < root) {
                return false;
            }
        }
        return helper(preorder, low+1, i-1) && helper(preorder, i, high);
    }*/

}
