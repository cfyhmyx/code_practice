//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Find the minimum element. You may assume no duplicate exists in the array.

public class Leetcode153 {
    public static void main(String args[]) {
        int[] nums = {4,5,6,7,0,1,2};
        int result = findMin(nums);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]){
                return nums[i];
            }
        }
        return nums[0];
    }

    //better way
    /*  int start=0,end=num.size()-1;

        while (start<end) {
        if (num[start]<num[end])
            return num[start];

        int mid = (start+end)/2;

        if (num[mid]>=num[start]) {
            start = mid+1;
        } else {
            end = mid;
        }
    }

        return num[start];
        */
}
