//Assume you have an array of length n initialized with all 0's and are given k update operations.
//Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray
//A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
//Return the modified array after all k operations were executed.

public class Leetcode370 {
    public static void main(String args[]) {
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        int[] res = getModifiedArray(5, updates);
        for(int num : res) {
            System.out.println(num);
        }
    }

    //complexity: O(m+n)
    public static int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];

            res[start] += value;

            if(end < length - 1)
                res[end + 1] -= value;

        }
        for(int i=1; i<length; i++) {
            res[i] += res[i-1];
        }
        return res;
    }

}
