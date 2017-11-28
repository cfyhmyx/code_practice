//Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
//You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

public class Leetcode459 {
    public static void main(String args[]) {
        boolean result = repeatedSubstringPattern("abab");
        System.out.println(result);
    }

    public static boolean repeatedSubstringPattern(String s) {
        int[] next = new int[s.length()];
        char[] pattern = s.toCharArray();
        int index = 0;
        for(int i=1; i<s.length();) {
            if(pattern[i] == pattern[index]) {
                next[i] = index+1;
                index++;
                i++;
            } else {
                if(index != 0) {
                    index = next[index-1];
                } else {
                    next[i]=0;
                    i++;
                }
            }
        }
        return next[s.length()-1] > 0 && s.length()%(s.length()-next[s.length()-1])==0;
    }
}
