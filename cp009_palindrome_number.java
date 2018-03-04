//Determine whether an integer is a palindrome. Do this without extra space.

public class Leetcode009 {
    public static void main(String args[]) {
        boolean result = isPalindrome(12321);
        System.out.println(result);
    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int factor = 1;
        int temp = x;
        while(temp/10 > 0) {
            temp = temp/10;
            factor *= 10;
        }

        while(x>0) {
            if(x%10 != x/factor) {
                return false;
            }
            x = x%factor;
            x = x/10;
            factor = factor/100;
        }

        return true;
    }
}
