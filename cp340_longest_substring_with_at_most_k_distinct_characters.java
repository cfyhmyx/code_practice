//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.

public class Leetcode340 {
    public static void main(String args[]) {
        String s = "eceba";
        int result = lengthOfLongestSubstringKDistinct(s, 2);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k>=s.length()) return s.length();
        int[] map = new int[256];
        int left = 0;
        int right = 0;
        int length = 0;
        int counter = 0;
        while(right < s.length()) {
            if(map[s.charAt(right)]==0) {
                counter++;
            }
            map[s.charAt(right)]++;
            right++;
            while(counter>k) {
                if(map[s.charAt(left)]==1) {
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
