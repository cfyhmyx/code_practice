//You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
//you and your friend take turns to flip two consecutive "++" into "--".
//The game ends when a person can no longer make a move and therefore the other person will be the winner.
//Write a function to determine if the starting player can guarantee a win.

import java.util.*;

public class Leetcode294 {
    public static void main(String args[]) {
        boolean result = canWin("+++++-");
        System.out.println(result);
    }

    public static boolean canWin(String s) {
        if(s.length()<2) return false;
        Map<String, Boolean> map = new HashMap<>();
        return canWin(s, map);
    }

    private static boolean canWin(String s, Map<String, Boolean> map) {
        List<String> arr = new ArrayList<>();
        if(map.containsKey(s)) return map.get(s);
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i,i+2, "--");
                arr.add(sb.toString());
            }
        }
        for(String str : arr) {
            if(!canWin(str, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    /*public boolean canWin(String s) {
        return helper(s, new HashMap<>());
    }

    private boolean helper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        for (int i = 0; i < s.length() - 1; ++i) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }

        map.put(s, false);
        return false;
    }*/

}
