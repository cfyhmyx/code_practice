//Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

public class Leetcode167 {
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int result[] = twoSum(nums, 9);
        for (int i=0; i<result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length-1;
        int[] result = new int[2];
        while(low < high) {
            if(numbers[low] + numbers[high] > target) {
                high--;
            } else if(numbers[low] + numbers[high] < target) {
                low++;
            } else {
                result[0] = low+1;
                result[1] = high+1;
                break;
            }
        }
        return result;
    }

}
