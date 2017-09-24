//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//Find all the elements that appear twice in this array.
//Could you do it without extra space and in O(n) runtime?
import java.util.ArrayList;
import java.util.List;

public class Leetcode442 {
    public static void main(String args[]) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findDuplicates(nums);
        System.out.println(result);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for(int num : nums) {
            if(nums[Math.abs(num)-1] < 0) {
                result.add(Math.abs(num));
            } else {
                nums[Math.abs(num)-1] *= -1;
            }
        }
        return result;
    }
}
