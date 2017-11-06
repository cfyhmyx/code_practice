//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//Given two integers x and y, calculate the Hamming distance.

public class Leetcode461 {
    public static void main(String args[]) {
        int result = hammingDistance(1,4);
        System.out.println(result);
    }

    public static int hammingDistance(int x, int y) {
        int temp = x^y;
        int result = 0;
        while(temp>0) {
            result += temp & 1;
            temp = temp>>1;
        }
        return result;
    }
}
