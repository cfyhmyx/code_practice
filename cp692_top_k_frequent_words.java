//Given a non-empty list of words, return the k most frequent elements.
//Your answer should be sorted by frequency from highest to lowest.
//If two words have the same frequency, then the word with the lower alphabetical order comes first.

import java.util.*;

public class Leetcode692 {
    public static void main(String args[]) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> result = topKFrequent(words, 2);
        System.out.println(result);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequecyMap = new HashMap<>();
        List<String>[] bucket = new ArrayList[words.length+1];
        for(int i=0; i<words.length; i++) {
            frequecyMap.put(words[i], frequecyMap.getOrDefault(words[i], 0)+1 );
        }
        for(String key : frequecyMap.keySet()) {
            if(bucket[frequecyMap.get(key)] == null) {
                bucket[frequecyMap.get(key)] = new ArrayList<>();
            }
            bucket[frequecyMap.get(key)].add(key);
        }
        List<String> result = new ArrayList<>();
        for(int i=bucket.length-1; i>0; i--) {
            if(bucket[i] == null) continue;
            Collections.sort(bucket[i]);
            for(String s : bucket[i]) {
                result.add(s);
                if(result.size() == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
