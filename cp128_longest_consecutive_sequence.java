//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Leetcode128 {
    public static void main(String args[]) {
        int[] nums = {100, 4, 200, 1, 2, 3};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }
        int best = 0;
        for(int n : set) {
            if(!set.contains(n - 1)) {  
                int m = n + 1;
                while(set.contains(m)) {
                    m++;
                }
                best = Math.max(best, m - n);
            }
        }
        return best;
    }

    /*public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int result = 0;
        Iterator<Integer> it = set.iterator();
        Set<Integer> visited = new HashSet<>();
        while(it.hasNext()) {
            int cur = it.next();
            if(visited.contains(cur)) continue;
            visited.add(cur);
            int temp = 1;
            int right = cur+1;
            while(set.contains(right) && !visited.contains(right)){
                visited.add(right);
                right++;
                temp++;
            }
            int left = cur-1;
            while(set.contains(left) && !visited.contains(left)) {
                visited.add(left);
                left--;
                temp++;
            }
            result = Math.max(result, temp);
        }
        return result;
    }*/
}
