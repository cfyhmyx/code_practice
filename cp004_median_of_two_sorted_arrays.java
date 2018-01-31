//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

//explaination: http://blog.csdn.net/chen_xinjia/article/details/69258706
public class Leetcode004 {
    public static void main(String args[]) {

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int N1 = nums1.length;
        int N2 = nums2.length;
        if (N1 > N2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        if (N1 == 0)
            return ((double) nums2[(N2 - 1) / 2] + (double) nums2[N2 / 2]) / 2;
        int size = N1 + N2;
        int cutL = 0, cutR = N1;
        int cut1 = N1 / 2;
        int cut2 = size / 2 - cut1;

        while (cut1 <= N1) {
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = size / 2 - cut1;

            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == N1) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == N2) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2)
                cutR = cut1 - 1;
            else if (L2 > R1)
                cutL = cut1 + 1;
            else {// Otherwise, that's the right cut.
                if (size % 2 == 0) {
                    L1 = (L1 > L2 ? L1 : L2);
                    R1 = (R1 < R2 ? R1 : R2);
                    return (L1 + R1) / 2;
                }

                else {
                    R1 = (R1 < R2 ? R1 : R2);
                    return R1;
                }
            }
        }
        return -1;
    }
}
