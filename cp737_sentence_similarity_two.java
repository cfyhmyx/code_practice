//https://leetcode.com/problems/sentence-similarity-ii/description/

import java.util.HashMap;
import java.util.Map;

public class Leetcode737 {
    public static void main(String args[]) {

    }

    private Map<String, Integer> rank;
    private Map<String, String> root;

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if(words1.length != words2.length) return false;
        rank = new HashMap<>();
        root = new HashMap<>();
        for(String[] pair : pairs) {
            if(!rank.containsKey(pair[0])) {
                rank.put(pair[0], 0);
                root.put(pair[0], pair[0]);
            }
            if(!rank.containsKey(pair[1])) {
                rank.put(pair[1], 0);
                root.put(pair[1], pair[1]);
            }
            union(pair[0],pair[1]);
        }
        for(int i=0; i<words1.length; i++) {
            if(words1[i].equals(words2[i])) continue;
            if(!root.containsKey(words1[i]) || !root.containsKey(words2[i]) || union(words1[i], words2[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean union(String string0, String string1) {
        String root0 = find(string0);
        String root1 = find(string1);
        if(root0.equals(root1)) {
            return false;
        }
        if(rank.get(root0)>=rank.get(root1)) {
            if(rank.get(root0)==rank.get(root1)){
                rank.put(root0,rank.get(root0)+1);
            }
            root.put(root1, root0);
        } else {
            root.put(root0, root1);
        }
        return true;
    }

    private String find(String str) {
        if(root.get(str).equals(str)) {
            return str;
        }
        String rt = find(root.get(str));
        root.put(str, rt);
        return rt;
    }
}
