//Design and implement a TwoSum class. It should support the following operations: add and find.
//add - Add the number to an internal data structure.
//find - Find if there exists any pair of numbers which sum is equal to the value.

import java.util.ArrayList;
import java.util.HashSet;

public class Leetcode170 {
    public static void main(String args[]) {

    }

    public class TwoSum {
        ArrayList<Integer> list;

        /** Initialize your data structure here. */
        public TwoSum() {
            list = new ArrayList<>();
        }

        // Add the number to an internal data structure.
        public void add(int number) {
            list.add(number);
        }

        // Find if there exists any pair of numbers which sum is equal to the value.
        public boolean find(int value) {
            HashSet<Integer> set = new HashSet<>();
            for(Integer num : list){
                if(set.contains(value - num)){
                    return true;
                }
                set.add(num);
            }
            return false;
        }
    }

}
