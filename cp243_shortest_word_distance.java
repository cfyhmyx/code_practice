//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

public class Leetcode243 {
    public static void main(String args[]) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        int result = shortestDistance(words, "makes", "coding");
        System.out.println(result);
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int index1 = -1;
        int index2 = -1;
        int result = words.length;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals(word1)) {
                index1 = i;
                if(index2 != -1) {
                    result = Math.min(result, index1-index2);
                }
            } else if(words[i].equals(word2)) {
                index2 = i;
                if(index1 != -1) {
                    result = Math.min(result, index2-index1);
                }
            }
        }
        return result;
    }
}
