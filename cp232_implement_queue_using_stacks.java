//https://leetcode.com/problems/implement-queue-using-stacks/description/

import java.util.Stack;

public class Leetcode232 {
    public static void main(String args[]) {

    }

    class MyQueue {

        Stack<Integer> s;

        /** Initialize your data structure here. */
        public MyQueue() {
            s = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            Stack<Integer> tempS = new Stack<>();
            int n = s.size();
            for(int i=0; i<n; i++) {
                tempS.add(s.pop());
            }
            s.add(x);
            for(int i=0; i<n; i++) {
                s.add(tempS.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return s.pop();
        }

        /** Get the front element. */
        public int peek() {
            return s.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s.isEmpty();
        }
    }

}
