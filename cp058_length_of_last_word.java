//Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
//return the length of last word in the string. If the last word does not exist, return 0.
//Note: A word is defined as a character sequence consists of non-space characters only.

public class Leetcode058 {
    public static void main(String args[]) {
    }

    public int lengthOfLastWord(String s) {
        if(s==null ||s.length() == 0) return 0;
        int result = 0;
        char[] arr = s.toCharArray();
        int i=s.length()-1;
        for(; i>=0; i--) {
            if(arr[i] != ' ') {
                break;
            }
        }
        while(i>=0 && arr[i]!= ' ') {
            result++;
            i--;
        }
        return result;
    }
}
