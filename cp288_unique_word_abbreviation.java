//https://leetcode.com/problems/unique-word-abbreviation/description/

import java.util.HashMap;

public class Leetcode288 {
    public static void main(String args[]) {
        String[] dic = {"deer", "door", "cake", "card"};
        ValidWordAbbr vw = new ValidWordAbbr(dic);
        boolean res = vw.isUnique("dear");
        System.out.println(res);
    }

    static class ValidWordAbbr {

        HashMap<String, String> map;
        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for(String str:dictionary){
                String key = getKey(str);
                // If there is more than one string belong to the same key
                // then the key will be invalid, we set the value to ""
                if(map.containsKey(key)){
                    if(!map.get(key).equals(str)){
                        map.put(key, "");
                    }
                }
                else{
                    map.put(key, str);
                }
            }
        }

        public boolean isUnique(String word) {
            return !map.containsKey(getKey(word))||map.get(getKey(word)).equals(word);
        }

        String getKey(String str){
            if(str.length()<=2) return str;
            return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
        }
    }
}
