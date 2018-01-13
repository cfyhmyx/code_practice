//https://leetcode.com/problems/h-index/description/

public class Leetcode275 {
    public static void main(String args[]) {
        int[] citations = {100};
        int result = hIndex(citations);
        System.out.println(result);
    }

    public static int hIndex(int[] citations) {
        int m = citations.length;
        int left = 0;
        int right = m-1;
        while(left<=right) {
            int mid = left + (right-left)/2;
            if(citations[mid] == m-mid) return citations[mid];
            if(citations[mid] < m-mid) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return m-(right+1);
    }

}
