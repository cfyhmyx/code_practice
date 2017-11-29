//Given two 1d vectors, implement an iterator to return their elements alternately.

import java.util.*;

public class Leetcode281 {
    public static void main(String args[]) {

    }

    public class ZigzagIterator {

        Queue<Iterator> q;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            q = new LinkedList();
            if (!v1.isEmpty()) q.offer(v1.iterator());
            if (!v2.isEmpty()) q.offer(v2.iterator());
        }

        public int next() {
            Iterator cur = q.poll();
            int res = (int) cur.next();
            if (cur.hasNext()) q.offer(cur);
            return res;
        }

        public boolean hasNext() {
            return q.peek() != null;
        }
    }

    /*public class ZigzagIterator {

        Queue<Integer> queue = new LinkedList<>();

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            int index = 0;
            while(index<v1.size() || index<v2.size()) {
                if(index<v1.size()) {
                    queue.add(v1.get(index));
                }
                if(index<v2.size()) {
                    queue.add(v2.get(index));
                }
                index++;
            }
        }

        public int next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }*/

}
