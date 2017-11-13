//Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer
//given in the form of an array.

//explaination: https://discuss.leetcode.com/topic/50489/c-clean-and-short-solution

public class Leetcode372 {
    public static void main(String args[]) {

    }

    public static int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }

    private static int superPow(int a, int[] b, int length, int k) {
        if(length == 0) return 1;
        return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
    }

    private static int powMod(int x, int power, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < power; i++) {
            pow = (pow * x) % k;
        }
        return pow;
    }

}
