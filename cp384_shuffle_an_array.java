//Shuffle a set of numbers without duplicates.

import java.util.Random;

public class Leetcode384 {
    public static void main(String args[]) {

    }

    public class Solution {
        private int[] nums;
        private Random random;

        public Solution(int[] nums) {
            this.nums = nums;
            random = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        // e.g : 0,1,2,3, 0 stay at 0 position: 1*(1/2)*(2/3)*(3/4)
        public int[] shuffle() {
            if(nums == null) return null;
            int[] a = nums.clone();
            for(int j = 0; j < a.length; j++) {
                int i = random.nextInt(j + 1);
                swap(a, i, j);
            }
            return a;
        }

        private void swap(int[] a, int i, int j) {
            int t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
    }
}
