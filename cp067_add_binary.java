//Given two binary strings, return their sum (also a binary string).

public class Leetcode067 {
    public static void main(String args[]) {
        String result = addBinary("1","111" );
        System.out.println(result);
    }

    public static String addBinary(String a, String b) {
        if(b.length() > a.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int diff = a.length()-b.length();
        for(int i=0; i<diff; i++) {
            b = "0" + b;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i=a.length()-1; i>=0; i--) {
            int sum = a.charAt(i)-'0'+b.charAt(i)-'0'+carry;
            result.insert(0, sum%2);
            carry = sum/2;
        }
        if(carry == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
