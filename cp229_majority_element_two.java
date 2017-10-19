//Given an integer array of size n, find all elements that appear more than ⌊n/3⌋ times.
//The algorithm should run in linear time and in O(1) space.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode229 {
    public static void main(String args[]) {
        int[] nums = {};
        List<Integer> result = majorityElement(nums);
        System.out.println(result);
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> frequency = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }
        for(int num : frequency.keySet()) {
            int freq = frequency.get(num);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(num);
        }
        List<Integer> result = new ArrayList();
        for(int i=nums.length; i>nums.length/3; i--) {
            if(bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }

    //better way
    /*public List<Integer> majorityElement(int[] nums) {
        List<Integer>result = new ArrayList<>();
        if(nums==null || nums.length == 0) return result;
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }else if(count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                num2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == num1){
                count1++;
            }else if(nums[i] == num2){
                count2++;
            }
        }
        if(count1>len/3) result.add(num1);
        if(count2>len/3) result.add(num2);

        return result;
    }*/

}
