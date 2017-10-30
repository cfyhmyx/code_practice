//Given a column title as appear in an Excel sheet, return its corresponding column number.

public class Leetcode171 {
    public static void main(String args[]) {
        int result = titleToNumber("SDGVDS");
        System.out.println(result);
    }

    public static int titleToNumber(String s) {
        int result = 0;
        for(int i = 0; i<s.length(); i++) {
            int add = s.charAt(i)-'A'+1;
            result = result*26+add;
        }
        return result;
    }

}
