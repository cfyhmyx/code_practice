//Given a sorted array, two integers k and x, find the k closest elements to x in the array.
//The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

import java.util.*;

public class Leetcode658 {
    public static void main(String args[]) {

    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if(arr == null || arr.length == 0 || k == 0){
            return res;
        }
        int l = 0;
        int r = arr.length-k;
        while(l<r){
            int mid = l+(r-l)/2;
            if(x - arr[mid] > arr[mid+k]-x){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        for(int i = l; i<l+k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}
