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
        return helper(s, new HashMap<>());
    }

    private static boolean helper(String s, Map<String, Boolean> map) {
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
    }

}
