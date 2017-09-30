//description: https://leetcode.com/problems/maximum-length-of-pair-chain/description/
import java.util.*;

public class Leetcode646 {
    public static void main(String args[]) {
        int[][] pairs = {{1,2},{2,3},{3,6},{7,9},{4,7}};
        int result = findLongestChain(pairs);
        System.out.println(result);
    }

    public static int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) return 0;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int result = 1;
        int lastEnd = pairs[0][1];
        for(int i=1; i<pairs.length; i++) {
            if(pairs[i][0] > lastEnd) {
                result++;
                lastEnd = pairs[i][1];
            } else if(pairs[i][1] < lastEnd) {
                lastEnd = pairs[i][1];
            }
        }
        return result;
    }

    //sort by end
    /*public int findLongestChain(int[][] pairs) {
        if (pairs.length == 1) return 1;
        Arrays.sort(pairs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });

        int res = 1, end = pairs[0][1];
        for(int i = 1; i < pairs.length; i++){
            if (pairs[i][0] > end) {
                res++;
                end = pairs[i][1];
            }
        }
        return res;
    }*/
}
