//description: https://leetcode.com/problems/heaters/description/
import java.util.Arrays;

public class Leetcode475 {
    public static void main(String args[]) {
        int[] houses = {3, 1, 2, 4};
        int[] heaters = {1, 4};
        int result = findRadius(houses, heaters);
        System.out.println(result);
    }

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result = 0;
        for (int i=0; i<houses.length; i++) {
            int index = Arrays.binarySearch(heaters, houses[i]);
            if(index < 0) {
                index = -(index + 1);
            }
            int leftDis = Integer.MAX_VALUE;
            int rightDis = Integer.MAX_VALUE;

            if(index - 1>=0) {
                leftDis = Math.abs(houses[i] - heaters[index-1]);
            }

            if(index < heaters.length) {
                rightDis = Math.abs(heaters[index] - houses[i]);
            }

            result = Math.max(result, Math.min(leftDis, rightDis));
        }
        return result;
    }
}
