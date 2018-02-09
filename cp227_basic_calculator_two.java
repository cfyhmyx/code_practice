//Implement a basic calculator to evaluate a simple expression string.
//The expression string contains only non-negative integers, +, -, *, / operators and empty spaces.
//The integer division should truncate toward zero. You may assume that the given expression is always valid.

import java.util.Stack;

public class Leetcode227 {
    public static void main(String args[]) {

    }

    public int calculate(String s) {
        if(s==null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        char sign = '+';
        int num = 0;
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                num = s.charAt(i) - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num*10+s.charAt(i+1)-'0';
                    i++;
                }
            }
            if(!Character.isDigit(s.charAt(i))&&s.charAt(i)!=' '||i == s.length()-1) {
                if(sign == '+') stack.push(num);
                else if(sign == '-') stack.push(-num);
                else if(sign == '*') stack.push(stack.pop()*num);
                else if(sign == '/') stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        for(int i : stack) {
            res += i;
        }
        return res;
    }

}
