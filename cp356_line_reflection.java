//Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

import java.util.*;

public class Leetcode356 {
    public static void main(String args[]) {

    }

    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            max = Math.max(max,p[0]);
            min = Math.min(min,p[0]);
            String str = p[0] + "," + p[1];
            set.add(str);
        }
        int sum = max+min;
        for(int[] p:points){
            String str = (sum-p[0]) + "," + p[1];
            if( !set.contains(str))
                return false;

        }
        return true;
    }

}
