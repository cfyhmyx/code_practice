//Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//Example:
//(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
//(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

public class Leetcode324 {
    public static void main(String args[]) {
        int[] nums = {1, 5, 1, 1, 6, 4,2};
        wiggleSort(nums);
        for(int i=0; i<nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void wiggleSort(int[] nums) {
        int median=findKthLargest(nums,(
                nums.length+1)/2);
        int odd=1;
        int even=nums.length%2==0?nums.length-2:nums.length-1;
        int[] tmpArr=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>median){
                tmpArr[odd]=nums[i];
                odd+=2;
                continue;
            }
            if(nums[i]<median){
                tmpArr[even]=nums[i];
                even-=2;
                continue;
            }
        }
        while(odd<nums.length){
            tmpArr[odd]=median;
            odd+=2;
        }
        while(even>=0){
            tmpArr[even]=median;
            even-=2;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=tmpArr[i];
        }
    }

    public static int findKthLargest(int[] nums, int k) {
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int mid = low + (high-low)/2;
            int swap = nums[mid];
            nums[mid] = nums[high];
            nums[high] = swap;
            int pivot = nums[high];
            int smallerIndex = low-1;
            for(int i=low; i<high; i++) {
                if(nums[i] <= pivot) {
                    smallerIndex++;
                    int temp = nums[smallerIndex];
                    nums[smallerIndex] = nums[i];
                    nums[i] = temp;
                }
            }
            int temp = nums[smallerIndex+1];
            nums[smallerIndex+1] = pivot;
            nums[high] = temp;

            if(smallerIndex+1 == nums.length-k) return pivot;
            else if(smallerIndex+1 < nums.length-k){
                low = smallerIndex+2;
            } else {
                high = smallerIndex;
            }
        }
        return nums[low];
    }

}
