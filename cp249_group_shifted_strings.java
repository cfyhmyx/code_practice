//Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd".
//We can keep "shifting" which forms the sequence:
//"abc" -> "bcd" -> ... -> "xyz"
//Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

import java.util.*;

public class Leetcode249 {
    public static void main(String args[]) {
        String[] strs = {"abc","bcd","acef","xyz","az","ba","a","z"};
        List<List<String>> result = groupStrings(strs);
        for(List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String t: strings) {
            char[] sc = t.toCharArray();
            int dif = sc[0] - 'a';
            for (int i = 0; i < sc.length; i++) {
                sc[i] -= dif;
                if (sc[i] < 'a') sc[i] += 26;
            }
            String key = new String(sc);
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(t);
        }
        res.addAll(map.values());
        return res;
    }
}
