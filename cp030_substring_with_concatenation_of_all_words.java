//You are given a string, s, and a list of words, words, that are all of the same length.
//Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode030 {
    public static void main(String args[]) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> result = findSubstring(s, words);
        System.out.println(result);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s==null || s.length()==0 || words == null || words.length==0) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length;i++) {
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }
        int wl = words[0].length();

        for(int i=0; i<wl; i++) {
            Map<String, Integer> curMap = new HashMap<>();
            int counter = 0;
            int left = i;
            for(int right=i; right<=s.length()-wl; right+=wl) {
                String cur = s.substring(right, right+wl);
                if(map.containsKey(cur)) {
                    curMap.put(cur, curMap.getOrDefault(cur, 0)+1);
                    if(curMap.get(cur)<=map.get(cur)) {
                        counter++;
                    } else {
                        while(curMap.get(cur)>map.get(cur)) {
                            String temp = s.substring(left, left+wl);
                            curMap.put(temp, curMap.get(temp)-1);
                            if(curMap.get(temp)<map.get(temp)){
                                counter--;
                            }
                            left = left+wl;
                        }
                    }
                    if(counter == words.length) {
                        result.add(left);
                        String temp = s.substring(left, left+wl);
                        curMap.put(temp, curMap.get(temp)-1);
                        counter--;
                        left = left+wl;
                    }
                } else {
                    curMap.clear();
                    counter = 0;
                    left = right+wl;
                }
            }
        }
        return result;
    }

}
