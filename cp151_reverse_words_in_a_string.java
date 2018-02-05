//Given an input string, reverse the string word by word.

public class Leetcode151 {
    public static void main(String args[]) {
        String s = "   a   b ";
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        String[] strs = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            res.append(strs[i]).append(" ");
        }
        return res.toString().trim();
    }

}
