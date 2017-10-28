//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//Find the minimum element. You may assume no duplicate exists in the array.
//Elements could be duplicated

public class Leetcode154 {
    public static void main(String args[]) {
        int[] nums = {10,1,10,10,10};
        int result = findMin(nums);
        System.out.println(result);
    }

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            if(nums[low] < nums[high]) {
                return nums[low];
            }
            int mid = low + (high-low)/2;
            if(nums[mid] > nums[low]) {
                low = mid+1;
            } else if(nums[mid] < nums[low]){
                high = mid;
            } else {
                low++;
            }
        }
        return nums[low];
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
