//Given a pattern and a string str, find if str follows the same pattern.
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

import java.util.HashMap;

public class Leetcode290 {
    public static void main(String args[]) {

    }

    public static boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }
}
