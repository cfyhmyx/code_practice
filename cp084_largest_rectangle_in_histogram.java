//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

import java.util.Stack;

public class Leetcode084 {
    public static void main(String args[]) {
    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max_area = 0;
        for(int i=0; i<=heights.length; ++i){
            int height_bound = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty()){
                int h = heights[stack.peek()];

                // calculate the area for every ascending slope.
                if(h < height_bound){
                    break;
                }
                stack.pop();

                // at the end, the area with the height of the minimal element.
                int index_bound = stack.isEmpty() ? -1 : stack.peek();
                max_area = Math.max(max_area, h*((i-1)-index_bound));
            }
            stack.push(i);
        }
        return max_area;
    }
}
