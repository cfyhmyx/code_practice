//Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//Valid operators are +, -, *, /. Each operand may be an integer or another expression.

import java.util.Stack;

public class Leetcode150 {
    public static void main(String args[]) {
        String[] tokens = {"0", "3","/"};
        int sum = evalRPN(tokens);
        System.out.println(sum);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int sum = 0;
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(tokens[i].equals("+")) {
                    sum = num1+num2;
                } else if(tokens[i].equals("-")) {
                    sum = num2-num1;
                } else if (tokens[i].equals("*")) {
                    sum = num1*num2;
                } else {
                    sum = num2/num1;
                }
                stack.push(sum);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }

}
