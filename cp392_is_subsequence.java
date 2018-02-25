//Given a string s and a string t, check if s is subsequence of t.
//You may assume that there is only lower case English letters in both s and t.
//t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
//A subsequence of a string is a new string which is formed from the original string
//by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters.
//(ie, "ace" is a subsequence of "abcde" while "aec" is not).

public class Leetcode392 {
    public static void main(String args[]) {
        String t = "abcadea";
        String s = "dea";
        boolean result = isSubsequence(s, t);
        System.out.println(result);
    }

    public static boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) return true;
        int index = 0;
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if(index == s.length()) {
                return true;
            }
        }
        return false;
    }

    //follow up: if we have too many string S
    /*public boolean isSubsequence(String s, String t) {
        List<Integer>[] map = new List[26];
        for(int i=0; i<t.length(); i++){
            int ch = t.charAt(i)-'a';
            if(map[ch]==null){
                map[ch] = new ArrayList<>();
            }
            map[ch].add(i);
        }

        //check string s
        int prevIdx = 0;
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(map[ch]==null) return false;
            int j = Collections.binarySearch(map[ch], prevIdx);
            if(j<0) j = -j - 1; // binarySearch return  (-(insertion point) - 1) if not found
            if(j==map[ch].size()) return false;
            prevIdx = map[ch].get(j) + 1;
        }
        return true;
    }*/

}
