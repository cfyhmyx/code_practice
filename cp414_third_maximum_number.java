//Given a non-empty array of integers, return the third maximum number in this array.
//If it does not exist, return the maximum number. The time complexity must be in O(n).

public class Leetcode414 {
    public static void main(String args[]) {
        int[] nums = {1,2,2,5,3,5};
        int result = thirdMax(nums);
        System.out.println(result);
    }

    public static int thirdMax(int[] nums) {
        int first = nums[0];
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        boolean secondInit = false;
        boolean thirdInit = false;
        for(int i=1; i<nums.length; i++) {
            int orginFirst = first;
            int orginSecond = second;
            if(nums[i] >= first) {
                first = nums[i];
                if(first!=orginFirst) {
                    second = orginFirst;
                    if(secondInit && second!=orginSecond) {
                        third = orginSecond;
                        thirdInit = true;
                    }
                    secondInit = true;
                }
            } else if(nums[i] >= second) {
                second = nums[i];
                if(secondInit && second!=orginSecond){
                    third = orginSecond;
                    thirdInit = true;
                }
                secondInit = true;
            } else if(nums[i] >= third) {
                third = nums[i];
                thirdInit = true;
            }
        }
        return thirdInit ? third : first;
    }

    //better way
    /*public int thirdMax(int[] nums)
    {
        long max1 = Long.MIN_VALUE;
        long max2 = max1;
        long max3 = max1;

        for(int num: nums)
        {
            if(num > max1)
            {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if(num > max2 && num != max1)
            {
                max3 = max2;
                max2 = num;
            }
            else if(num > max3 && num != max1 && num != max2)
            {
                max3 = num;
            }
        }

        return max3 == Long.MIN_VALUE ? (int)max1 : (int)max3;
    }*/
}
