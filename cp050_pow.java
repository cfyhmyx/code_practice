//Implement pow(x, n)

public class Leetcode050 {
    public static void main(String args[]) {
        double result = myPow(2, 5 );
        System.out.println(result);
    }

    public static double myPow(double x, int n) {
        if(n < 0) {
            return 1/helper(x, n);
        } else {
            return helper(x, n);
        }
    }

    public static double helper(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        double temp = helper(x, n/2);
        if(n%2 == 0) {
            return temp*temp;
        } else {
            return temp*temp*x;
        }
    }
}
