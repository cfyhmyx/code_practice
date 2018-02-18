//Given a sorted positive integer array nums and an integer n, add/patch elements to the array
//such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array.
//Return the minimum number of patches required.

public class Leetcode330 {
    public static void main(String args[]) {

    }

    //Let miss be the smallest sum in [0,n] that we might be missing.
    //Meaning we already know we can build all sums in [0,miss).
    //Then if we have a number num <= miss in the given array,
    //we can add it to those smaller sums to build all sums in [0,miss+num).
    //If we don’t, then we must add such a number to the array,
    //and it’s best to add miss itself, to maximize the reach.
    public int minPatches(int[] nums, int n) {
        long missing = 1;
        int patches = 0, i = 0;

        while (missing <= n) {
            if (i < nums.length && nums[i] <= missing) {
                missing += nums[i++];
            } else {
                missing += missing;
                patches++;
            }
        }
        return patches;
    }

}
