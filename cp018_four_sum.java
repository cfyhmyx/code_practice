//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
//Find all unique quadruplets in the array which gives the sum of target.
//Note: The solution set must not contain duplicate quadruplets.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode018 {
    public static void main(String args[]) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return kSum_Trim(nums, target, 4);
    }

    List<List<Integer>> kSum_Trim(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || a.length < k || k < 2) return result;
        Arrays.sort(a);
        kSum_Trim(a, target, k, 0, result, new ArrayList<>());
        return result;
    }

    void kSum_Trim(int[] a, int target, int k, int start, List<List<Integer>> result, List<Integer> path) {
        int max = a[a.length - 1];
        if (a[start] * k > target || max * k < target) return;

        if (k == 2) {                        // 2 Sum
            int left = start;
            int right = a.length - 1;
            while (left < right) {
                if      (a[left] + a[right] < target) left++;
                else if (a[left] + a[right] > target) right--;
                else {
                    result.add(new ArrayList<>(path));
                    result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                    left++; right--;
                    while (left < right && a[left] == a[left - 1]) left++;
                    while (left < right && a[right] == a[right + 1]) right--;
                }
            }
        } else {                        // k Sum
            for (int i = start; i < a.length - k + 1; i++) {
                if (i > start && a[i] == a[i - 1]) continue;
                if (a[i] + max * (k - 1) < target) continue;
                if (a[i] * k > target) break;
                path.add(a[i]);
                kSum_Trim(a, target - a[i], k - 1, i + 1, result, path);
                path.remove(path.size() - 1);        // Backtracking
            }
        }
    }

}
