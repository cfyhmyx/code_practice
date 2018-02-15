//Additive number is a string whose digits can form additive sequence.
//A valid additive sequence should contain at least three numbers.
//Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

public class Leetcode306 {
    public static void main(String args[]) {

    }

    public boolean isAdditiveNumber(String num) {
        for(int i=1; i<=num.length()/2; i++) {                          //i: length of the first number
            for(int j=1; Math.max(i, j)<=num.length()-i-j; j++) {       //j: length of the second number
                if(isValid(i, j, num)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if(num.charAt(0) == '0' && i>1) return false;
        if(num.charAt(i) == '0' && j>1) return false;
        String sum = "";
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i+j));
        for(int start = i+j; start != num.length(); start+=sum.length()) {
            x2 = x1+x2;
            x1 = x2-x1;
            sum = x2.toString();
            if(!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }

}
