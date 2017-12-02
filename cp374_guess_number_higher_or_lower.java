//We are playing the Guess Game. The game is as follows:
//I pick a number from 1 to n. You have to guess which number I picked.
//Every time you guess wrong, I'll tell you whether the number is higher or lower.
//You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):

public class Leetcode374 {
    public static void main(String args[]) {
        int result = guessNumber(6);
        System.out.println(result);
    }

    public static int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low<= high) {
            int mid = low + (high-low)/2;
            if(guess(mid) == 0) return mid;
            else if(guess(mid) == -1) high = mid-1;
            else low = mid+1;
        }
        return -1;
    }

    private static int guess(int num) {
        if(num == 6) return 0;
        else if(num<6) return 1;
        else return -1;
    }

}
