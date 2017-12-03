//Write a function to generate the generalized abbreviations of a word.

import java.util.ArrayList;
import java.util.List;

public class Leetcode320 {
    public static void main(String args[]) {
        List<String> result = generateAbbreviations("word");
        System.out.println(result);
    }

    public static List<String> generateAbbreviations(String word){
        List<String> result = new ArrayList<String>();
        backtrack(result, word, 0, "", 0);
        return result;
    }

    private static void backtrack(List<String> result, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            result.add(cur);
        }
        else{
            backtrack(result, word, pos + 1, cur, count + 1);
            backtrack(result, word, pos + 1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
}
