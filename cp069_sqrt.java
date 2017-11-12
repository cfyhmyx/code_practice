//Implement int sqrt(int x)

public class Leetcode069 {
    public static void main(String args[]) {
        double result = mySqrt(35 );
        System.out.println(result);
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        int left = 1;
        int right = x;
        while(left <= right) {
            int mid = left + ((right-left)/2);
            if(mid <= x/mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return right;
    }
}
