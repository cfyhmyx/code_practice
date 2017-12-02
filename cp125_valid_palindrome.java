//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

import java.util.ArrayList;
import java.util.List;

public class Leetcode125 {
    public static void main(String args[]) {
        String s = "0o";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }

        return true;
    }

    /*public static boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()) return true;
        char[] chars = s.toCharArray();
        List<Character> arr = new ArrayList<>();
        for(char ch : chars) {
            if(Character.isLetterOrDigit(ch)) {
                arr.add(Character.toUpperCase(ch));
            }
        }
        int low = 0;
        int high = arr.size()-1;
        while(low<high) {
            if(arr.get(low++) != arr.get(high--)) {
                return false;
            }
        }
        return true;
    }*/
}
