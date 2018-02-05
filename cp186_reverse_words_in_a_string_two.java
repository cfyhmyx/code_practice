//Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
//The input string does not contain leading or trailing spaces and the words are always separated by a single space.

public class Leetcode186 {
    public static void main(String args[]) {

    }

    public static void reverseWords(char[] str) {
        if(str.length <= 1) return;
        int low = 0;
        int high = str.length-1;
        reverse(str, low, high);
        int i=0;
        while(i<str.length) {
            int j=i;
            while(j<str.length && str[j] != ' ') j++;
            reverse(str, i, j-1);
            i = j+1;
        }
        return;
    }

    private static void reverse(char[] str, int low, int high) {
        while(low < high) {
            char temp = str[low];
            str[low++] = str[high];
            str[high--] = temp;
        }
        return;
    }

}
