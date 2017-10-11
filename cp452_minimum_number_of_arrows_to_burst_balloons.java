//Description: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/

import java.util.*;

public class Leetcode452 {
    public static void main(String args[]) {
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        int result = findMinArrowShots(points);
        System.out.println(result);
    }

    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int result = 1;
        int localEnd = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(points[i][0] > localEnd) {
                result++;
                localEnd = points[i][1];
            } else {
                localEnd = Math.min(localEnd, points[i][1]);
            }
        }
        return result;
    }

}
