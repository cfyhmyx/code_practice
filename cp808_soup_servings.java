//https://leetcode.com/problems/soup-servings/description/

public class Leetcode808 {
    public static void main(String args[]) {
        double result = soupServings(800);
        System.out.println(result);
    }

    public static double soupServings(int N) {
        if(N>=4800) return 1;
        return helper(N, N,new Double[N+1][N+1]);
    }

    private static double helper(int aleft, int bleft, Double[][] cache) {
        if(aleft > 0 && bleft <= 0) {
            return 0;
        } else if(aleft <= 0 && bleft <= 0) {
            return 0.5;
        } else if(aleft <= 0 && bleft > 0)  {
            return 1;
        }
        if(cache[aleft][bleft] != null) return cache[aleft][bleft];
        cache[aleft][bleft] = helper(aleft-100, bleft, cache) + helper(aleft-75, bleft-25, cache)
                            + helper(aleft-50, bleft-50, cache) + helper(aleft-25, bleft-75, cache);
        cache[aleft][bleft] *= 0.25;
        return cache[aleft][bleft];
    }

}
