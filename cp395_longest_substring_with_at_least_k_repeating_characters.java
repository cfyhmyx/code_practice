//Find the length of the longest substring T of a given string (consists of lowercase letters only)
//such that every character in T appears no less than k times.

public class Leetcode395 {
    public static void main(String args[]) {

    }

    public int longestSubstring(String s, int k) {
        int res = 0;
        for(int numUniqueTarget = 1; numUniqueTarget <= 26; numUniqueTarget++) {
            res = Math.max(res, slideWindow(s, k, numUniqueTarget));
        }
        return res;
    }

    private int slideWindow(String s, int k, int numUniqueTarget) {
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int numUnique = 0;
        int numNoLessThanK = 0;
        int res = 0;
        while(right < s.length()) {
            if(map[s.charAt(right)-'a'] == 0) {
                numUnique++;
            }
            map[s.charAt(right)-'a']++;
            if(map[s.charAt(right)-'a'] == k) {
                numNoLessThanK++;
            }
            right++;
            while(numUnique > numUniqueTarget) {
                if(map[s.charAt(left)-'a'] == k) {
                    numNoLessThanK--;
                }
                map[s.charAt(left)-'a']--;
                if(map[s.charAt(left)-'a'] == 0) {
                    numUnique--;
                }
                left++;
            }
            if(numUnique == numUniqueTarget && numUnique == numNoLessThanK) {
                res = Math.max(right-left, res);
            }
        }
        return res;
    }

}
