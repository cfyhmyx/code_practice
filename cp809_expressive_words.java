//https://leetcode.com/problems/expressive-words/description/

public class Leetcode809 {
    public static void main(String args[]) {

    }

    public int expressiveWords(String S, String[] words) {
        if(words == null || words.length == 0) return 0;
        int result = 0;
        for(String word : words) {
            if(word.length() > S.length()) continue;
            int i = 0;
            int j = 0;
            for(; j<S.length(); j++) {
                if(i<word.length() && word.charAt(i) == S.charAt(j)) {
                    i++;
                } else if(j>0 && S.charAt(j) == S.charAt(j-1) && j+1<S.length() && S.charAt(j) == S.charAt(j+1)) {
                    j++;
                } else if(!(j>1 && S.charAt(j) == S.charAt(j-1) && S.charAt(j) == S.charAt(j-2))) {
                    break;
                }
            }
            if(i == word.length() && j==S.length()) {
                result++;
            }
        }
        return result;
    }

}
