//Given a string, sort it in decreasing order based on the frequency of characters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode451 {
    public static void main(String args[]) {
        String result = frequencySort("treeaaaabbwww");
        System.out.println(result);
    }

    public static String frequencySort(String s) {
        if(s == null && s.isEmpty()) return "";
        List<Character>[] bucket = new List[s.length()+1];
        Map<Character, Integer> frequency = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0)+1);
        }
        for(char ch : frequency.keySet()) {
            int fre = frequency.get(ch);
            if(bucket[fre] == null) {
                bucket[fre] = new ArrayList<>();
            }
            bucket[fre].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length(); i>0; i--) {
            if(bucket[i] == null) continue;
            for(int j=0; j<bucket[i].size(); j++) {
                for(int k=0; k<i; k++) {
                    sb.append(bucket[i].get(j));
                }
            }
        }
        return sb.toString();
    }

}
