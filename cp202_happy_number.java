//Write an algorithm to determine if a number is "happy".
//A happy number is a number defined by the following process: Starting with any positive integer,
//replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
//(where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy numbers.

import java.util.HashSet;

public class Leetcode202 {
    public static void main(String args[]) {

    }

    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(set.add(n)) {
            int squareSum = 0;
            while(n>0) {
                int remain = n%10;
                squareSum += remain*remain;
                n /= 10;
            }
            if(squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

}
