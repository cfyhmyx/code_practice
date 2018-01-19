//Given two arrays of length m and n with digits 0-9 representing two numbers.
//Create the maximum number of length k <= m + n from digits of the two.
//The relative order of the digits from the same array must be preserved.
//Return an array of the k digits. You should try to optimize your time and space complexity.

public class Leetcode321 {
    public static void main(String args[]) {

    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        //i: from nums1, we get at least i numbers
        for(int i=Math.max(0, k-n); i<=k&&i<=m; i++) {
            int[] temp = merge(maxArray(nums1, i), maxArray(nums2, k-i), k);
            if(greater(temp, 0, res, 0)){
                res = temp;
            }
        }
        return res;
    }

    private static int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for(int i=0, j=0, r=0; r<k; r++) {
            res[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return res;
    }

    private static boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i<nums1.length && j<nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }

    private static int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        for(int i=0, j=0; i<n; i++) {
            while(n-i>k-j && j>0 && nums[i]>res[j-1]) {
                j--;
            }
            if(j<k) {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}
