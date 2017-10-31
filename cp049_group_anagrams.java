import java.util.*;

public class Leetcode049 {
    public static void main(String args[]) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for(List<String> group : result) {
            System.out.println(group);
        }
    }

    //complexity: n*klogk, k is the average of these word length
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            if(map.get(sorted) == null) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }
        for(String key : map.keySet()){
            result.add(new ArrayList<>(map.get(key)));
        }
        return result;
    }

    //complexity: nk
    /*public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> groups = new HashMap<>();
        for(String str : strs) {
            if(str == null) {
                continue;
            }
            char[] counter = new char[26];
            for(char ch : str.toCharArray()) {
                counter[ch - 'a']++;
            }
            String anagram = new String(counter);
            List<String> group = groups.get(anagram);
            if(group == null) {
                group = new ArrayList<String>();
                groups.put(anagram, group);
                res.add(group);
            }
            group.add(str);
        }
        return res;
    }*/
}
