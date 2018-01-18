//Given an integer, write a function to determine if it is a power of four.

public class Leetcode342 {
    public static void main(String args[]) {

    }

    public boolean isPowerOfFour(int num) {
        return num>0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }

}
