//You are climbing a stair case. It takes n steps to reach to the top.
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Leetcode070 {
    public static void main(String args[]) {
        double result = climbStairs(5);
        System.out.println(result);
    }

    public static int climbStairs(int n) {
        int low = 1;
        int high  = 1;
        for (int i=2; i<=n; i++) {
            int temp = high;
            high = low + high;
            low = temp;
        }
        return high;
    }
}
