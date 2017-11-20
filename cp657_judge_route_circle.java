//Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
//The move sequence is represented by a string. And each move is represent by a character.
//The valid robot moves are R (Right), L (Left), U (Up) and D (down).
//The output should be true or false representing whether the robot makes a circle.

public class Leetcode657 {
    public static void main(String args[]) {
        boolean result = judgeCircle("ULDR");
        System.out.println(result);
    }

    public static boolean judgeCircle(String moves) {
        int[] result = new int[2];
        for(int i=0; i<moves.length(); i++) {
            if(moves.charAt(i) == 'U'){
                result[1]++;
            } else if(moves.charAt(i) == 'D') {
                result[1]--;
            } else if(moves.charAt(i) == 'L') {
                result[0]--;
            } else if(moves.charAt(i) == 'R') {
                result[0]++;
            }
        }
        return result[0] == 0 && result[1] == 0;
    }
}
