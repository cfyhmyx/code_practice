import java.util.ArrayList;
import java.util.List;

public class Leetcode647 {
    public static void main(String args[]) {
        String s = "aaa";
        int total = countSubstrings(s);
        System.out.println(total);
    }

    public static int countSubstrings(String s) {
        int m = s.length();
        int[][] cash = new int[m][m];
        int total = 0;

        for(int j=0; j<m; j++) {
            for(int i=0; i<=j; i++) {
                 if(i==j) {
                     total += 1;
                     cash[i][j] = 1;
                 } else if(s.charAt(i) == s.charAt(j)){
                     if(i+1 == j || cash[i+1][j-1] == 1) {
                         cash[i][j] = 1;
                         total += 1;
                     }
                 }
            }
        }
        return total;
    }
}
