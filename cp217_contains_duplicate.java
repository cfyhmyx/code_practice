//Given an array of integers, find if the array contains any duplicates.
//Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

import java.util.HashSet;

public class Leetcode217 {
    public static void main(String args[]) {

    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=nums.length-1;i>-1;i--){
            if(!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

}
