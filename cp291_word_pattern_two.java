//Given a pattern and a string str, find if str follows the same pattern.
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

import java.util.HashMap;

public class Leetcode291 {
    public static void main(String args[]) {

    }

    public boolean wordPatternMath(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        return isMatch(str, 0, pattern, 0, map);
    }

    private boolean isMatch(String str, int i, String pattern, int j, HashMap<Character, String> map) {
        if(i==str.length() && j==pattern.length()) return true;
        if(i==str.length() || j==pattern.length()) return false;

        char c = pattern.charAt(j);
        if(map.containsKey(c)) {
            String s = map.get(c);
            if(!str.startsWith(s, i)) {
                return false;
            }
            return isMatch(str, i+s.length(), pattern, j+1, map);
        }

        for(int k=i; k<str.length(); k++) {
            String p = str.substring(i, k+1);
            if(map.containsValue(p)) continue;
            map.put(c, p);
            if(isMatch(str, k+1, pattern, j+1, map)) {
                return true;
            }
            map.remove(c);
        }
        return false;
    }
}
