//Given a collection of distinct numbers, return all possible permutations.

import java.util.ArrayList;
import java.util.List;

public class Leetcode046 {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = permute(nums);
        System.out.println(res);
    }

    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        permute(num,0,result);
        return result;
    }


    private static  void permute(int[] num, int begin, List<List<Integer>> result){
        if(begin>=num.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<num.length;i++){
                list.add(num[i]);
            }
            result.add(list);
            return;
        }
        for(int i=begin;i<num.length;i++){
            swap(begin,i,num);
            permute(num,begin+1,result);
            swap(begin,i,num);

        }
    }

    private static void swap (int x, int y,int[] num){
        int temp = num[x];
        num[x]=num[y];
        num[y]=temp;
    }

    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if (nums == null || nums.length == 0)
            return res;
        helper(res, new ArrayList(), nums, new boolean[nums.length]);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }*/

}
