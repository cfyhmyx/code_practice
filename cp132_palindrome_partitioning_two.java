//Given a string s, partition s such that every substring of the partition is a palindrome.
//Return the minimum cuts needed for a palindrome partitioning of s.
//For example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class Leetcode132 {
    public static void main(String args[]) {

    }

    public static int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int[] cuts = new int[len];
        boolean[][] isPalindrome = new boolean[len][len];
        for(int i=0; i<len; i++) {
            int min = i;    //if a string length is m, the maximum cuts would be m-1
            for(int j=0; j<=i; j++) {
                if(s.charAt(j) == s.charAt(i) && (i-j<=2 || isPalindrome[j+1][i-1])) {
                    isPalindrome[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cuts[j-1]+1);
                }
            }
            cuts[i] = min;
        }
        return cuts[len-1];
    }

}
