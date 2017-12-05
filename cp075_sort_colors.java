//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
//with the colors in the order red, white and blue.
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

public class Leetcode075 {
    public static void main(String args[]) {
        int[] nums = {0,2,1};
        sortColors(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static void sortColors(int[] nums) {
        int red = -1;
        int blue = nums.length;
        for(int white=0; white>red && white<blue;) {
            if(nums[white] == 0) {
                red++;
                int temp = nums[red];
                nums[red] = nums[white];
                nums[white] = temp;
                white++;
            } else if (nums[white] == 2){
                blue--;
                int temp = nums[blue];
                nums[blue] = nums[white];
                nums[white] = temp;
            } else {
                white++;
            }
        }
    }
}
