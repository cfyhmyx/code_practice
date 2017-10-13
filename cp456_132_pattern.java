//description: Given a sequence of n integers a1, a2, ..., an,
//a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj.
//Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

import java.util.Stack;

public class Leetcode456 {
    public static void main(String args[]) {
        int[] nums = {3,5,0,3,4};
        boolean result = find132pattern(nums);
        System.out.println(result);
    }

    public static boolean find132pattern(int[] nums) {
        int a3 = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for(int i=nums.length-1; i>=0; i--) {
            if(nums[i] < a3) return true;
            while(!s.isEmpty() && nums[i]>s.peek()) {
                a3 = s.peek();
                s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }
}
