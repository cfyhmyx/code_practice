//https://leetcode.com/problems/trapping-rain-water/description/

public class Leetcode042 {
    public static void main(String args[]) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trap(height);
        System.out.println(result);
    }

    public static int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length-1;
        int leftMax = 0;
        int rightMax = 0;
        while(left<right) {
            if(height[left]<=height[right]) {
                if(height[left]<leftMax) {
                    result += leftMax-height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if(height[right]<rightMax) {
                    result += rightMax-height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return result;
    }
}
