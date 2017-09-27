//description: https://leetcode.com/problems/student-attendance-record-i/description/
public class Leetcode551 {
    public static void main(String args[]) {
        boolean result = checkRecord("PPALLPPPPLL");
        System.out.println(result);
    }

    public static boolean checkRecord(String s) {
        int numA = 0;
        int numL = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'L') {
                numL++;
                if(numL>2) return false;
            } else {
                numL = 0;
                if(s.charAt(i) == 'A') {
                    numA++;
                    if(numA>1) return false;
                }
            }
        }
        return true;
    }
}
