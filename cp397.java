/*(Given a positive integer n and you can do operations as follow:
1.If n is even, replace n with n/2.
2.If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?*/

public class Leetcode397 {
    public static void main(String args[]) {
        int n = Integer.MAX_VALUE - 1;
        int result = integerReplacement(n);
        System.out.println(result);
    }

    public static int integerReplacement(int n) {
        //Interger.MAX_VALUE is an odd number, but you cannot add 1
        if (n == Integer.MAX_VALUE) n = Integer.MAX_VALUE-1;
        int result = 0;
        while(n != 1) {
            if(n % 2 == 0) {
                n = n/2;
            } else {
                if((n+1)%4==0 && (n-1 != 2)) n++;
                else n--;
            }
            result++;
        }
        return result;
    }

}
