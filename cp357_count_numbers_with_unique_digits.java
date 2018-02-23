//Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

public class Leetcode357 {
    public static void main(String args[]) {

    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
            n--;
        }
        return res;
    }

}
