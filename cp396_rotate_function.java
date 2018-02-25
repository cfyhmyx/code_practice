//Given an array of integers A and let n to be its length.
//Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
//F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
//Calculate the maximum value of F(0), F(1), ..., F(n-1).

public class Leetcode396 {
    public static void main(String args[]) {
        int[] A = {4,3,2,6};
        int result = maxRotateFunction(A);
        System.out.println(result);
    }

    public static int maxRotateFunction(int[] A) {
        int sum = 0;
        int candidate = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i];
            candidate += A[i]*i;
        }
        int res = candidate;
        for(int i=A.length-1; i>0; i--) {
            candidate = candidate+sum-A[i]*A.length;
            res = Math.max(res, candidate);
        }
        return res;
    }

    //native method
    /*public static int maxRotateFunction(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int result = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int local = 0;
            for(int k = 0; k<n; k++) {
                local += k*A[k-i<0 ? k+n-i : k-i];
            }
            result = Math.max(result, local);
        }
        return result;
    }*/

}
