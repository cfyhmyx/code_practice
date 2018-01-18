//Design a max stack that supports push, pop, top, peekMax and popMax.
//push(x) -- Push element x onto stack.
//pop() -- Remove the element on top of the stack and return it.
//top() -- Get the element on the top.
//peekMax() -- Retrieve the maximum element in the stack.
//popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

import java.util.PriorityQueue;
import java.util.Stack;

public class Leetcode716 {
    public static void main(String args[]) {

    }

    class MaxStack {

        Stack<Integer> s;
        PriorityQueue<Integer> pq;
        /** initialize your data structure here. */
        public MaxStack() {
            s = new Stack<>();
            pq = new PriorityQueue<>((a,b)->b-a);
        }

        public void push(int x) {
            s.push(x);
            pq.offer(x);
        }

        public int pop() {
            int pop = s.pop();
            pq.remove(pop);
            return pop;
        }

        public int top() {
            return s.peek();
        }

        public int peekMax() {
            return pq.peek();
        }

        public int popMax() {
            int max = pq.poll();
            Stack<Integer> sp = new Stack<>();
            while (!s.isEmpty()) {
                if (s.peek() != max) {
                    sp.push(s.pop());
                } else {
                    s.pop();
                    break;
                }
            }
            while (!sp.isEmpty()) {
                s.push(sp.pop());
            }
            return max;
        }
    }
    
}
