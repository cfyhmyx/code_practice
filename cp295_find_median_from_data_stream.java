//You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
//you and your friend take turns to flip two consecutive "++" into "--".
//The game ends when a person can no longer make a move and therefore the other person will be the winner.
//Write a function to determine if the starting player can guarantee a win.

import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode295 {
    public static void main(String args[]) {

    }

    class MedianFinder {

        private Queue<Integer> maxHeap;
        private Queue<Integer> minHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2)->(o2-o1));
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(maxHeap.size()<minHeap.size())	maxHeap.add(minHeap.poll());
        }

        public double findMedian() {
            return maxHeap.size()>minHeap.size()?maxHeap.peek(): (maxHeap.peek() + minHeap.peek())/2.0;
        }
    }

}
