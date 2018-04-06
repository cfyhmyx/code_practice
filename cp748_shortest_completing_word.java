//https://leetcode.com/problems/shortest-completing-word/description/

import java.util.Arrays;

public class Leetcode748 {
    public static void main(String args[]) {

    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        for(int i=0; i<licensePlate.length(); i++) {
            if(Character.isLetter(licensePlate.charAt(i))) {
                Character ch = Character.toLowerCase(licensePlate.charAt(i));
                map[ch-'a']++;
            }
        }
        int minLength = Integer.MAX_VALUE;
        String result = null;
        String pattern = Arrays.toString(map);
        for(String word : words) {
            if(word.length() >= minLength) continue;
            int[] temp = new int[26];
            for(int i=0; i<word.length(); i++) {
                if(temp[word.charAt(i)-'a'] < map[word.charAt(i)-'a']) {
                    temp[word.charAt(i)-'a']++;
                }
            }
            String tempString = Arrays.toString(temp);
            if(tempString.equals(pattern)) {
                result = word;
                minLength = word.length();
            }
        }
        return result;
    }

}