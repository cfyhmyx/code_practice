//You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -,
//you and your friend take turns to flip two consecutive "++" into "--".
//The game ends when a person can no longer make a move and therefore the other person will be the winner.
//Write a function to compute all possible states of the string after one valid move.

import java.util.ArrayList;
import java.util.List;

public class Leetcode293 {
    public static void main(String args[]) {
        List<String> result = generatePossibleNextMoves("++++");
        System.out.println(result);
    }

    public static List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                StringBuilder sb = new StringBuilder(s);
                sb.replace(i,i+2, "--");
                result.add(sb.toString());
            }
        }
        return result;
    }
}
