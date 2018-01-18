//Given an integer, write a function to determine if it is a power of three.

public class Leetcode326 {
    public static void main(String args[]) {

    }

    public static boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

}
