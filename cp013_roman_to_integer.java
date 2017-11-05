//Given a roman numeral, convert it to an integer.
//Input is guaranteed to be within the range from 1 to 3999.

import java.util.HashMap;
import java.util.Map;

public class Leetcode013 {
    public static void main(String args[]) {
        int result = romanToInt("IX");
        System.out.println(result);
    }

    private static final Map<Character, Integer> myMap;
    static
    {
        myMap = new HashMap();
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X',10);
        myMap.put('L',50);
        myMap.put('C',100);
        myMap.put('D', 500);
        myMap.put('M', 1000);
    }

    public static int romanToInt(String s) {
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            if(i>0 && myMap.get(s.charAt(i)) > myMap.get(s.charAt(i-1))) {
                result = result - 2*myMap.get(s.charAt(i-1));
            }
            result += myMap.get(s.charAt(i));
        }
        return result;
    }
}
