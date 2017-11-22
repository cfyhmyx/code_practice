//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

public class Leetcode076 {
    public static void main(String args[]) {
        String s = "a";
        String t = "b";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    public static String minWindow(String s, String t) {
        if(s==null || s.isEmpty() || t==null || t.isEmpty()) {
            return "";
        }
        int[] map = new int[256];
        for(int i=0; i<t.length(); i++) {
            map[t.charAt(i)]++;
        }
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int counter = t.length();
        while(right < s.length()) {
            if(map[s.charAt(right)] >= 1) {
                counter--;
            }
            map[s.charAt(right)]--;
            right++;
            while(counter == 0) {
                if(right-left<minLength) {
                    start = left;
                    minLength = right-left;
                }
                if(map[s.charAt(left)]>=0) {
                    counter++;
                }
                map[s.charAt(left)]++;
                left++;
            }
        }
        if(start != -1) {
            return s.substring(start, start+minLength);
        } else {
            return "";
        }
    }
}
