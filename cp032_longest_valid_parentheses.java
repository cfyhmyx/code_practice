//Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//For "(()", the longest valid parentheses substring is "()", which has length = 2.
//Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
import java.util.Stack;

public class Leetcode032 {
    public static void main(String args[]) {
        int result = longestValidParentheses("()())))()()()");
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> left = new Stack<>();
        int lastRight = -1;
        int length = 0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            } else {
                if(left.empty()) {
                   lastRight = i;
                } else {
                    left.pop();
                    if(left.empty()) {
                        length = Math.max(length, i-lastRight);
                    } else {
                        length = Math.max(length, i-left.peek());
                    }
                }
            }
        }
        return length;
    }
}
