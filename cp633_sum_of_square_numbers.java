//Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

public class Leetcode633 {
    public static void main(String args[]) {
        boolean result = judgeSquareSum(5 );
        System.out.println(result);
    }

    public static boolean judgeSquareSum(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
