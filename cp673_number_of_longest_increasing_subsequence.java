//Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

public class Leetcode673 {
    public static void main(String args[]) {
        int[] nums = {1,2,22,222};
        int result = findNumberOfLIS(nums);
        System.out.println(result);
    }

    //len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
    //cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1)cnt[i] += cnt[j];
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i])res += cnt[i];
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
