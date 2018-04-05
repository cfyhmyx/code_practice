//https://leetcode.com/problems/escape-the-ghosts/description/

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode789 {
    public static void main(String args[]) {

    }

    public int numTilings(int N) {
        int max = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] ghost : ghosts) {
            int d = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
            if (d <= max) return false;
        }
        return true;
    }

}
