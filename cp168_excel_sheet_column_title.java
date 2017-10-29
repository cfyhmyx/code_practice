//Given a positive integer, return its corresponding column title as appear in an Excel sheet.

public class Leetcode168 {
    public static void main(String args[]) {
        String result = convertToTitle(90);
        System.out.println(result);
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n>0) {
            n--;
            int offset = n%26;
            char add = (char)('A' + offset);
            result.insert(0,add);
            n = n/26;
        }
        return result.toString();
    }

}
