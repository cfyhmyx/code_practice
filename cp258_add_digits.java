//Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

public class Leetcode258 {
    public static void main(String args[]) {
    }

    public int addDigits(int num) {
        return (num-1)%9+1;
    }
}
