//Count the number of prime numbers less than a non-negative number, n.

public class Leetcode204 {
    public static void main(String args[]) {
        int result = countPrimes(3);
        System.out.println(result);
    }

    //O(nloglogn)
    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int res = 0;
        for(int i=2; i<n; i++) {
            if(notPrime[i] == false){
                res++;
                for(int j=2; i*j<n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return res;
    }
}
