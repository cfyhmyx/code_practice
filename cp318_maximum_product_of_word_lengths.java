//Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters.
//You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

import java.util.HashMap;
import java.util.Map;

public class Leetcode318 {
    public static void main(String args[]) {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        int result = maxProduct(words);
        System.out.println(result);
    }

    public static int maxProduct(String[] words) {
        if(words.length < 2) return 0;
        int result = 0;
        Map[] maps = new Map[words.length];
        for(int i=0; i<words.length; i++) {
            maps[i] = new HashMap();
            for(int j=0; j<words[i].length(); j++) {
                maps[i].put(words[i].charAt(j), 1);
            }
        }
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                int k=0;
                for(; k<words[j].length(); k++) {
                    if(maps[i].containsKey(words[j].charAt(k))) {
                        break;
                    }
                }
                if(k == words[j].length()) {
                    result = Math.max(result, words[i].length()*words[j].length());
                }
            }
        }
        return result;
    }

    //better way, since Integer has 32 bits, lower case only has 26, so 1<<char is enough to store
    /*public static int maxProduct(String[] words) {
        if (words == null || words.length == 0)
            return 0;
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String tmp = words[i];
            value[i] = 0;
            for (int j = 0; j < tmp.length(); j++) {
                value[i] |= 1 << (tmp.charAt(j) - 'a');
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j < len; j++) {
                if ((value[i] & value[j]) == 0 && (words[i].length() * words[j].length() > maxProduct))
                    maxProduct = words[i].length() * words[j].length();
            }
        return maxProduct;
    }*/
}
