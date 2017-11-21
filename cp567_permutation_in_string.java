//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
//In other words, one of the first string's permutations is the substring of the second string.

public class Leetcode567 {
    public static void main(String args[]) {
        String s1 = "aba";
        String s2 = "asdasbadsad";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;
        if(s1.length() == 0) return true;
        int[] map = new int[26];
        for(int i=0; i<s1.length(); i++) {
            map[s1.charAt(i)-'a']++;
        }
        int left = 0;
        int right = 0;
        int count = s1.length();

        while(right < s2.length()) {
            if(map[s2.charAt(right)-'a'] >= 1) {
                count--;
            }
            map[s2.charAt(right)-'a']--;
            right++;
            if(count == 0) {
                return true;
            }
            if(right-left == s1.length()){
                if(map[s2.charAt(left)-'a']>=0) {
                    count++;
                }
                map[s2.charAt(left)-'a']++;
                left++;
            }
        }
        return false;
    }
}
