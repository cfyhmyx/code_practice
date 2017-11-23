//Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
//For example, Given s = “eceba”, T is "ece" which its length is 3.

public class Leetcode159 {
    public static void main(String args[]) {
        String s = "eceba";
        int result = lengthOfLongestSubstringTwoDistinct(s);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
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
            while(counter>2) {
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
