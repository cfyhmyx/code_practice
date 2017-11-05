//Given an integer, convert it to a roman numeral.
//Input is guaranteed to be within the range from 1 to 3999.

import java.util.HashMap;
import java.util.Map;

public class Leetcode014 {
    public static void main(String args[]) {
        String result = intToRoman(23);
        System.out.println(result);
    }

    private static final Map<Integer, String> myMap;
    static
    {
        myMap = new HashMap();
        myMap.put(1, "I");
        myMap.put(4, "IV");
        myMap.put(5, "V");
        myMap.put(9, "IX");
        myMap.put(10,"X");
        myMap.put(40,"XL");
        myMap.put(50,"L");
        myMap.put(90,"XC");
        myMap.put(100,"C");
        myMap.put(400,"CD");
        myMap.put(500, "D");
        myMap.put(900,"CM");
        myMap.put(1000, "M");
    }

    private static final int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static String intToRoman(int num) {
        StringBuffer result = new StringBuffer();
        for(int i=0; i<arr.length && num>0; i++) {
            if(num/arr[i] > 0) {
                int loop = num/arr[i];
                while(loop-->0) {
                    result.append(myMap.get(arr[i]));
                }
                num = num%arr[i];
            }
        }
        return result.toString();
    }

    //more elegant method
    /*public class Solution {
    public String intToRoman(int number) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }
    }*/
}
