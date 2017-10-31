//Given two strings s and t, write a function to determine if t is an anagram of s.

public class Leetcode242 {
    public static void main(String args[]) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagram(s, t);
        System.out.println(result);
    }

    public static boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        if(s.length() != t.length()) return false;
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++){
            map[t.charAt(i)-'a']--;
            if(map[t.charAt(i)-'a'] <0) {
                return false;
            }
        }
        return true;
    }

}
