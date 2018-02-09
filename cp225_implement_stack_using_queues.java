//https://leetcode.com/problems/implement-stack-using-queues/description/

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode225 {
    public static void main(String args[]) {

    }

    class MyStack {

        Queue<Integer> q;

        /** Initialize your data structure here. */
        public MyStack() {
            q = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            Queue<Integer> tempQ = new LinkedList<>();
            int n = q.size();
            for(int i=0; i<n; i++) {
                tempQ.add(q.poll());
            }
            q.add(x);
            for(int i=0; i<n; i++) {
                q.add(tempQ.poll());
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return q.poll();
        }

        /** Get the top element. */
        public int top() {
            return q.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q.isEmpty();
        }
    }

}
