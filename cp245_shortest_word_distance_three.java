//This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
//Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
//word1 and word2 may be the same and they represent two individual words in the list.

public class Leetcode245 {
    public static void main(String args[]) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        int result = shortestDistance(words, "makes", "makes");
        System.out.println(result);
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int result = words.length;
        if(!word1.equals(word2)) {
            int index1 = -1;
            int index2 = -1;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    index1 = i;
                    if (index2 != -1) {
                        result = Math.min(result, index1 - index2);
                    }
                } else if (words[i].equals(word2)) {
                    index2 = i;
                    if (index1 != -1) {
                        result = Math.min(result, index2 - index1);
                    }
                }
            }
        } else {
            int index = -1;
            for(int i=0; i<words.length; i++) {
                if(words[i].equals(word1)) {
                    if(index != -1) {
                        result = Math.min(result, i-index);
                    }
                    index = i;
                }
            }
        }
        return result;
    }

    //shorter
    /*public int shortestWordDistance(String[] words, String word1, String word2) {
        long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
        boolean same = word1.equals(word2);
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                if (same) {
                    i1 = i2;
                    i2 = i;
                } else {
                    i1 = i;
                }
            } else if (words[i].equals(word2)) {
                i2 = i;
            }
            dist = Math.min(dist, Math.abs(i1 - i2));
        }
        return (int) dist;
    }*/
}
