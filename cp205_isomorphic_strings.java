//Given two strings s and t, determine if they are isomorphic.
//Two strings are isomorphic if the characters in s can be replaced to get t.
//All occurrences of a character must be replaced with another character while preserving the order of characters.
//No two characters may map to the same character but a character may map to itself.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    public static void main(String args[]) {
        boolean result = isIsomorphic("13","42");
        System.out.println(result);
    }

    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        Arrays.fill(map1, -1);
        Arrays.fill(map2, -1);
        for(int i=0; i<s.length(); i++) {
            if(map1[s.charAt(i)] != map2[t.charAt(i)]) {
                return false;
            }
            map1[s.charAt(i)] = i;
            map2[t.charAt(i)] = i;
        }
        return true;
    }

    /*public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map1.containsKey(s.charAt(i))) {
                map1.put(s.charAt(i), t.charAt(i));
            } else {
                if(map1.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            }
        }
        for(int j=0; j<t.length(); j++) {
            if(!map2.containsKey(t.charAt(j))) {
                map2.put(t.charAt(j), s.charAt(j));
            } else {
                if(map2.get(t.charAt(j)) != s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }*/
}
