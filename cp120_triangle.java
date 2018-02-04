//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode120 {
    public static void main(String args[]) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(6,5,7));
        list.add(Arrays.asList(4,1,8,3));
        int result = minimumTotal(list);
        System.out.println(result);
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if(m == 0) return 0;
        int[] result = new int[m];
        for(int i=0; i<m; i++) {
            result[i] = triangle.get(m-1).get(i);
        }

        for(int i=m-2; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size();j++) {
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j+1]);
            }
        }
        return result[0];
    }

}
