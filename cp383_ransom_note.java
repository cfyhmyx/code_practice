//Given an arbitrary ransom note string and another string containing letters from all the magazines,
//write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//Each letter in the magazine string can only be used once in your ransom note.
//Note: You may assume that both strings contain only lowercase letters.

public class Leetcode383 {
    public static void main(String args[]) {

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[256];
        for(char ch : magazine.toCharArray()) {
            map[ch]++;
        }
        for(char ch : ransomNote.toCharArray()) {
            if(--map[ch] < 0) {
                return false;
            }
        }
        return true;
    }
}
