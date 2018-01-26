//https://leetcode.com/problems/regular-expression-matching/description/

public class Leetcode010 {
    public static void main(String args[]) {
        boolean result = isMatch("aa", ".*");
        System.out.println(result);
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] match = new boolean[m+1][n+1];
        match[0][0] = true;

        for(int i=0; i<=s.length(); i++) {
            for (int j=1; j<=p.length(); j++) {
                if(i >= 1 && (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')) {
                    match[i][j] = match[i-1][j-1];
                } else if(p.charAt(j-1) == '*' && j>=2) {
                    match[i][j] = match[i][j-2];
                    if(i >= 1 && (p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.')) {
                        match[i][j] = match[i][j] || match[i-1][j];
                    }
                }
            }
        }
        return match[m][n];
    }
}
