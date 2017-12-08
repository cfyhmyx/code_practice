//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

public class Leetcode005 {
    public static void main(String args[]) {
        String result = longestPalindrome("babad");
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n<2) return s;
        int result = 0;
        int start = 0;
        boolean[][] dp = new boolean[n][n];
        for(int j=0; j<n; j++) {
            for(int i=0; i<=j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i<=2)||dp[i+1][j-1]);
                if(dp[i][j]) {
                    if(j-i+1>=result) {
                        result = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+result);
    }

    /*private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }}*/

    /*public static String longestPalindrome(String s) {
        if(s.length() < 2)
            return s;
        int longest = 0;
        int low_boundry = 0;
        for (int i=0; i<s.length(); i++) {
            int low = i;
            int count = 1;
            while(i < s.length()-1 && s.charAt(low) == s.charAt(i+1)) {
                i++;
                count++;
            }
            int high = i;
            while(low>0 && high<s.length()-1 && s.charAt(low-1) == s.charAt(high+1)){
                low--;
                high++;
                count += 2;
            }
            if(count>longest) {
                longest = count;
                low_boundry = low;
            }
        }
        return s.substring(low_boundry, low_boundry+longest);
    }*/
}
