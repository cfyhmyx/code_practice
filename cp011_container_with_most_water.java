//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.

public class Leetcode011 {
    public static void main(String args[]) {
        int[] height = {2, 4, 9, 3};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;
        while(left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = area > maxArea ? area : maxArea;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
