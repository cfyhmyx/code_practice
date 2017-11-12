//Given a positive integer num, write a function which returns True if num is a perfect square else False.

public class Leetcode367 {
    public static void main(String args[]) {
        boolean result = isPerfectSquare(5 );
        System.out.println(result);
    }

    public static boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(mid < (double)num/mid) {
                low = mid+1;
            } else if(mid > (double)num/mid) {
                high = mid-1;
            } else {
                return true;
            }
        }
        return false;
    }
}
