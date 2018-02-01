//https://leetcode.com/problems/permutation-sequence/description/

import java.util.ArrayList;
import java.util.List;

public class Leetcode060 {
    public static void main(String args[]) {

    }

    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            nums.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i=1; i<n; i++) {
            fact[i] = i*fact[i-1];
        }
        k = k-1; //0 based index
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>0; i--) {
            int index = k/fact[i-1];
            k = k%fact[i-1];
            sb.append(nums.get(index));
            nums.remove(index);
        }
        return sb.toString();
    }
}
