//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

public class Leetcode680 {
    public static void main(String args[]) {
        String s = "abca";
        boolean result = validPalindrome(s);
        System.out.println(result);
    }

    public static boolean validPalindrome(String s) {
        int l=0;
        int r=s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }
            ++l;
            --r;
        }
        return true;
    }

    private static boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
