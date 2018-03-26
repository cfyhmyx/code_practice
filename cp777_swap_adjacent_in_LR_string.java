//In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
//a move consists of either replacing one occurrence of "XL" with "LX",
//or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
//return True if and only if there exists a sequence of moves to transform one string to the other.

public class Leetcode777 {
    public static void main(String args[]) {
        boolean result = canTransform("RXXLRXRXL", "XRLXXRRLX");
        System.out.println(result);
    }


    public static boolean canTransform(String start, String end) {
        if (start.length () != end.length ())
            return false;
        char[] chs = start.toCharArray (), che = end.toCharArray ();
        int i = -1, j = -1;
        while (++i < chs.length && ++j < che.length) {
            // only care about L or R, skip X
            while (i < chs.length && chs[i] == 'X') i++;
            while (j < che.length && che[j] == 'X') j++;
            // number of L/R is not equal in both strings, can't transform
            if ((i < chs.length) ^ (j < che.length)) return false;
            if (i < chs.length && j < che.length) {
                // mismatched L/R
                if (chs[i] != che[j]) return false;
                // L can only move left
                if (chs[i] == 'L' && i < j) return false;
                // R can only move right
                if (chs[i] == 'R' && i > j) return false;
            }
        }
        return true;
    }

}
