//Reverse bits of a given 32 bits unsigned integer.
public class Leetcode191 {
    public static void main(String args[]) {
        int result = hammingWeight(321);
        System.out.println(result);
    }

    public static int hammingWeight(int n) {
        int result = 0;
        for(int i=0; i<32; i++) {
            result += n&1;
            n >>>= 1;
        }
        return result;
    }
}
