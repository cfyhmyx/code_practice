//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//The order of output does not matter.

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    public static void main(String args[]) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        for(int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[26]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right every time, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)-'a'] >= 1) {
                count--;
            }
            hash[s.charAt(right)-'a']--;
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {
                if (hash[s.charAt(left)-'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left)-'a']++;
                left++;
            }
        }
        return list;
    }
}
