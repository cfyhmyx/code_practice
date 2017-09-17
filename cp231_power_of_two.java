//Given an integer, write a function to determine if it is a power of two.

public class Leetcode231 {
    public static void main(String args[]) {
        boolean result = isPowerOfTwo(8);
        System.out.println(result);
    }

    public static boolean isPowerOfTwo(int n) {
        if(n<=0) return false;
        while(n%2 == 0) {
            n = n/2;
        }
        if(n==1) return true;
        else return false;
    }

    //the best way return n>0&&(n&(n-1))==0;

}
