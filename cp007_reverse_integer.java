//Given a 32-bit signed integer, reverse digits of an integer.

public class Leetcode007 {
    public static void main(String args[]) {
        int result = reverse(-900000000);
        System.out.println(result);
    }

    public static int reverse(int x) {
        double result = 0;
        while(x != 0) {
            int num = x%10;
            x = x/10;
            result = result*10 + num;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int)result;
    }
}
