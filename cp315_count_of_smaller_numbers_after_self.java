//You are given an integer array nums and you have to return a new counts array.
//The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode315 {
    public static void main(String args[]) {
        int[] nums = {5,2,6,1};
        List<Integer> result = countSmaller(nums);
        System.out.println(result);
    }

    public static List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        List<Integer> list = new ArrayList<>();
        for(int i=nums.length-1; i>=0; i--) {
            int index = findIndex(list, nums[i]);
            res[i] = index;
            list.add(index, nums[i]);
        }
        return Arrays.asList(res);
    }

    private static int findIndex(List<Integer> list, int num) {
        int low = 0;
        int high = list.size()-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(list.get(mid) >= num) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
