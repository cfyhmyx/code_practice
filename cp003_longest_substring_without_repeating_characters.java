//Given a string, find the length of the longest substring without repeating characters.

public class Leetcode003 {
    public static void main(String args[]) {
        int result = lengthOfLongestSubstring("abcabcbb");
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        int length = 0;
        int left = 0;
        int right = 0;
        int counter = 0;
        while(right < s.length()) {
            if(map[s.charAt(right)] > 0) {
                counter++;
            }
            map[s.charAt(right)]++;
            right++;
            while(counter>0) {
                if(map[s.charAt(left)] > 1) {
                    counter--;
                }
                map[s.charAt(left)]--;
                left++;
            }
            length = Math.max(length, right-left);
        }
        return length;
    }
}
