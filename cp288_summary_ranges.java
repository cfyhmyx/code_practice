//Given a sorted integer array without duplicates, return the summary of its ranges.
import java.util.ArrayList;
import java.util.List;

public class Leetcode228 {
    public static void main(String args[]) {
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> result = summaryRanges(nums);
        System.out.println(result);
    }

    public static List<String> summaryRanges(int[] nums) {
        int index = 0;
        List<String> result = new ArrayList<>();
        while(index < nums.length) {
            String temp = "";
            temp += nums[index];
            if(index + 1 < nums.length && nums[index+1] == nums[index]+1) {
                temp += "->";
                index++;
                while(index + 1 < nums.length && nums[index+1] == nums[index]+1) {
                    index++;
                }
                temp += nums[index];
            }
            result.add(temp);
            index++;
        }
        return result;
    }

}
