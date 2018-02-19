//Given two arrays, write a function to compute their intersection.
//Each element in the result should appear as many times as it shows in both arrays.

import java.util.*;

public class Leetcode350 {
    public static void main(String args[]) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1, nums2);
        for(int i=0; i<res.length; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0, j=0;
        List<Integer> arr = new ArrayList<>();
        while(i<nums1.length && j<nums2.length) {
            if(nums1[i] == nums2[j]) {
                arr.add(nums1[i]);
                i++;
                j++;
            } else if(nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[arr.size()];
        for(int k=0; k<arr.size(); k++) {
            res[k] = arr.get(k);
        }
        return res;
    }

}
