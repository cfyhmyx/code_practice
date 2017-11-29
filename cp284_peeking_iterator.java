//Given an Iterator class interface with methods: next() and hasNext(),
//design and implement a PeekingIterator that support the peek() operation.
//it essentially peek() at the element that will be returned by the next call to next().

import java.util.Iterator;

public class Leetcode284 {
    public static void main(String args[]) {

    }

    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> cur;
        int peek;
        boolean end;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            cur = iterator;
            peek = cur.next();
            end = false;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int result = peek;
            if(cur.hasNext()){
                peek = cur.next();
            } else {
                end = true;
            }
            return result;
        }

        @Override
        public boolean hasNext() {
            return !end;
        }
    }

}
