//Given two strings S and T, determine if they are both one edit distance apart.//You have the following 3 operations permitted on a word:
//a) Insert a character
//b) Delete a character
//c) Replace a character

public class Leetcode161 {
    public static void main(String args[]) {

    }

    public boolean isOneEditDistance(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        if (n2 < n1) {
            return isOneEditDistance(t, s);
        }
        boolean sameDist = (n1 == n2);
        for (int i = 0; i < n1; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sameDist) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return n1 + 1 == n2;
    }

}
