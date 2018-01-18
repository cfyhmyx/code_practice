//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.

import java.util.Stack;

public class Leetcode155 {
    public static void main(String args[]) {

    }

    class MinStack {

        Stack<Integer> nums;
        int min;

        /** initialize your data structure here. */
        public MinStack() {
            nums = new Stack<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            if(nums.isEmpty()) {
                nums.push(x);
                min = x;
            } else {
                nums.push(min);
                min = x < nums.peek() ? x : nums.peek();
                nums.push(x);
            }
        }

        public void pop() {
            nums.pop();
            if(!nums.isEmpty()) {
                min = nums.pop();
            } else {
                min = Integer.MAX_VALUE;
            }
        }

        public int top() {
            return nums.peek();
        }

        public int getMin() {
            return min;
        }
    }
    
}
