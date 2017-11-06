//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//Now your job is to find the total Hamming distance between all pairs of the given numbers.

public class Leetcode477 {
    public static void main(String args[]) {
        int[] nums = {4,14,2};
        int result = totalHammingDistance(nums);
        System.out.println(result);
    }

    public static int totalHammingDistance(int[] nums) {
        int total = 0, n = nums.length;
        for (int j=0;j<32;j++) {
            int bitCount = 0;
            for (int i=0;i<n;i++)
                bitCount += (nums[i] >> j) & 1;
            total += bitCount*(n - bitCount);
        }
        return total;
    }
}

