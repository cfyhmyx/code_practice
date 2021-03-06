//Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
//For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].

import java.util.ArrayList;
import java.util.List;

public class Leetcode163 {
    public static void main(String args[]) {
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long left = lower;
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            if(nums[i] == left+1) {
                result.add("" + left);
            } else if(nums[i] > left+1){
                result.add(""+left+"->"+(nums[i]-1));
            }
            left = (long)nums[i]+1;

        }

        if(left == upper) {
            result.add(""+left);
        } else if(left < upper) {
            result.add(""+left+"->"+upper);
        }
        return result;
    }

}
