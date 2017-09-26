//description: https://leetcode.com/problems/remove-element/description/
public class Leetcode027 {
    public static void main(String args[]) {
        int[] nums = {3};
        int result = removeElement(nums,3);
        System.out.println(result);
    }

    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            if(nums[left] == val) {
                while(nums[right] == val && right>left) {
                    right--;
                }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    //much easier way
    /*public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if (nums[j] != val){
                nums[i++] = nums[j];
            }
        }
        return i;*/
}
