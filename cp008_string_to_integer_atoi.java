//Implement atoi to convert a string to an integer.

public class Leetcode008 {
    public static void main(String args[]) {
        int result = myAtoi("   11113333333333333fdsa");
        System.out.println(result);
    }

    public static int myAtoi(String str) {
        int factor = 1;
        double result = 0;
        int index = 0;
        for(;index<str.length();index++) {
            if(!(str.charAt(index) == ' ')){
                break;
            }
        }

        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            if (str.charAt(index) == '-') {
                factor = -1;
            }
            index++;
        }

        for(;index<str.length();index++) {
            if(str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                result = result*10 + str.charAt(index) - '0';
            }
            else {
                break;
            }
        }

        result *= factor;
        if(result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }

        return (int)result;
    }
}
