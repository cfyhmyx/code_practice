//There is a list of sorted integers from 1 to n. Starting from left to right,
//remove the first number and every other number afterward until you reach the end of the list.
//Repeat the previous step again, but this time from right to left,
//remove the right most number and every other number from the remaining numbers.
//We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
//Find the last number that remains starting with a list of length n.

import java.util.LinkedList;
import java.util.List;

public class Leetcode390 {
    public static void main(String args[]) {
        int result = lastRemaining(9);
        System.out.println(result);
    }

    public static int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head = head + step;
            }
            remaining = remaining / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }

    //native method
    /*public static int lastRemaining(int n) {
        List<Integer> list = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            list.add(i);
        }
        boolean forward = true;
        while(list.size() > 1) {
            if(forward) {
                for(int i=0; i<list.size(); i++) {
                    list.remove(i);
                }
            } else {
                for(int i=list.size()-1; i>=0; i-=2) {
                    list.remove(i);
                }
            }
            forward = !forward;
        }
        return list.get(0);
    }*/

}
