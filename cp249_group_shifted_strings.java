//Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
//We can keep "shifting" which forms the sequence:
//"abc" -> "bcd" -> ... -> "xyz"
//Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

import java.util.*;

public class Leetcode249 {
    public static void main(String args[]) {
        String[] strs = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> result = groupAnagrams(strs);
        for(List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap();
        for(String str : strs) {
            if(str.isEmpty()) continue;
            int offset = str.charAt(0)-'a';
            char[] group = new char[26];
            for(char ch : str.toCharArray()) {
                int index = ch-offset-'a' < 0 ? ch-offset-'a'+26 : ch-offset-'a';
                group[index]++;
            }
            String anagram = new String(group);
            if(map.get(anagram) == null) {
                map.put(anagram, new ArrayList<>());
            }
            map.get(anagram).add(str);
        }
        for(String key : map.keySet()){
            result.add(new ArrayList<>(map.get(key)));
        }
        return result;
    }
}
