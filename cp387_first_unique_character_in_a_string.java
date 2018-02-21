//Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

public class Leetcode387 {
    public static void main(String args[]) {

    }

    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
