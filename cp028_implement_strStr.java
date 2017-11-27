//Implement strStr(). Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

public class Leetcode028 {
    public static void main(String args[]) {
        String heystack = "hello";
        String needle = "ll";
        int result = strStr(heystack, needle);
        System.out.println(result);
    }

    public static int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        for(int i=0; i<haystack.length()-needle.length()+1; i++) {
            int j=0;
            while(j<needle.length()) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

}
