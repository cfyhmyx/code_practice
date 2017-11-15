//Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

public class Leetcode415 {
    public static void main(String args[]) {
        String result = addBinary("9999","1" );
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i=a.length()-1, j=b.length()-1; i>=0 || j>=0; i--,j--) {
            int num1 = i>=0 ? a.charAt(i)-'0' : 0;
            int num2 = j>=0 ? b.charAt(j)-'0' : 0;
            int sum = num1 + num2 + carry;
            result.append(sum%10);
            carry = sum/10;
        }
        if(carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
