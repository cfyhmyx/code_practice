//Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

public class Leetcode686 {
    public static void main(String args[]) {
        int result = repeatedStringMatch("abcd", "cdab");
        System.out.println(result);
    }

    public static int repeatedStringMatch(String A, String B) {
        int m = A.length();
        int n = B.length();
        char[] str = A.toCharArray();
        char[] pattern = B.toCharArray();
        for(int i=0; i<m; i++) {
            int j=0;
            while(j<n && str[(i+j)%m] == pattern[j]) {
                j++;
            }
            if(j==n) {
                return (i+j-1)/m+1;
            }
        }
        return -1;
    }
}
