//Given a non-empty string, encode the string such that its encoded length is the shortest.
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
//Note:
//k will be a positive integer and encoded string will not be empty or have extra space.
//You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
//If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.

public class Leetcode471 {
    public static void main(String args[]) {

    }

    public class Solution {
        public String encode(String s) {
            if(s == null || s.length() <= 4) return s;

            int len = s.length();

            String[][] dp = new String[len][len];

            // iterate all the length, stay on the disgnose of the dp matrix
            for(int l = 0; l < len; l ++) {
                for(int i = 0; i < len - l; i ++) {
                    int j = i + l;
                    String substr = s.substring(i, j + 1);
                    dp[i][j] = substr;
                    if(l < 4) continue;

                    for(int k = i; k < j; k ++) {
                        if(dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }

                    String pattern = kmp (substr);
                    if(pattern.length() == substr.length()) continue; // no repeat pattern found
                    String patternEncode = substr.length() / pattern.length() + "[" + dp[i][i + pattern.length() - 1] + "]";
                    if(patternEncode.length() < dp[i][j].length()) {
                        dp[i][j] = patternEncode;
                    }
                }
            }

            return dp[0][len - 1];
        }

        private String kmp(String s){
            char[] pattern = s.toCharArray();
            int[] lps = new int[pattern.length];
            int index =0;
            for(int i=1; i < pattern.length;){
                if(pattern[i] == pattern[index]){
                    lps[i] = index + 1;
                    index++;
                    i++;
                }else{
                    if(index != 0){
                        index = lps[index-1];
                    }else{
                        lps[i] =0;
                        i++;
                    }
                }
            }
            int patternLen = s.length()-lps[s.length()-1];
            if(patternLen != s.length() && s.length()%patternLen == 0) {
                return s.substring(0, patternLen);
            } else {
                return s;
            }
        }

    }
}
