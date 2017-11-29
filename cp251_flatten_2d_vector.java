//Implement an iterator to flatten a 2d vector.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode251 {
    public static void main(String args[]) {

    }

    public class Vector2D{

        Queue<Integer> queue = new LinkedList<>();

        public Vector2D(List<List<Integer>> vec2d) {
            for(int i=0; i< vec2d.size(); i++) {
                for(int ele : vec2d.get(i)) {
                    queue.add(ele);
                }
            }
        }

        public Integer next() {
            return queue.poll();
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
