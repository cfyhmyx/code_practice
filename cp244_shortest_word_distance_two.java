//This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words
//and your method will be called repeatedly many times with different parameters. How would you optimize it?
//Design a class which receives a list of words in the constructor, and implements a method that takes two words
//word1 and word2 and return the shortest distance between these two words in the list.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Leetcode244 {
    public static void main(String args[]) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance wd = new WordDistance(words);
        int result = wd.shortest("coding", "makes");
        System.out.println(result);
    }

    static class WordDistance {

        Map<String, ArrayList<Integer>> map;

        public WordDistance(String[] words) {
            map = new HashMap<>();
            for(int i=0; i<words.length; i++) {
                if(!map.containsKey(words[i])) {
                    map.put(words[i], new ArrayList<>());
                }
                map.get(words[i]).add(i);
            }
        }

        //complexity(O(m+n))
        public int shortest(String word1, String word2) {
            int result = Integer.MAX_VALUE;
            ArrayList<Integer> list1 = map.get(word1);
            ArrayList<Integer> list2 = map.get(word2);
            int index1 = 0;
            int index2 = 0;
            while(index1<list1.size() && index2<list2.size()) {
                result = Math.min(result, Math.abs(list1.get(index1)-list2.get(index2)));
                if(list1.get(index1) < list2.get(index2)) {
                    index1++;
                } else {
                    index2++;
                }
            }
            return result;
        }
    }

}
