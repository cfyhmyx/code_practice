//Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
//(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

public class Leetcode738 {
    public static void main(String args[]) {

    }

    public static int monotoneIncreasingDigits(int N) {
        char[] num = String.valueOf (N).toCharArray();
        for (int idx = 0, start = 0; idx < num.length - 1; idx ++) {
            if (num[idx] > num[idx + 1]) {
                num[start] --;
                for (int jdx = start + 1; jdx < num.length; jdx ++) {
                    num[jdx] = '9';
                }
            } else if (num[idx] < num[idx + 1]) start = idx + 1;
        }
        return Integer.valueOf(String.valueOf (num));
    }
}
