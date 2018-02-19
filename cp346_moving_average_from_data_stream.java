//Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

import java.util.*;

public class Leetcode346 {
    public static void main(String args[]) {

    }

    class MovingAverage {

        private Queue<Integer> q;
        private int size;
        private double sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            q = new LinkedList<>();
            this.size = size;
            sum = 0;
        }

        public double next(int val) {
            q.offer(val);
            sum += val;
            if(q.size() > size) {
                sum -= q.poll();
            }
            return sum/q.size();
        }
    }
}
