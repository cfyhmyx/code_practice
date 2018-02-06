//Given a list of non negative integers, arrange them such that they form the largest number.
//For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
//Note: The result may be very large, so you need to return a string instead of an integer.

import java.util.Arrays;

public class Leetcode179 {
    public static void main(String args[]) {
        int[] nums = {999999998,999999997,999999999};
        String result = largestNumber(nums);
        System.out.println(result);
    }

    public static String largestNumber(int[] nums) {

        int m = nums.length;
        String[] transfer = new String[m];
        for(int i=0; i<m; i++) {
            transfer[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(transfer, (String s1, String s2)-> {
            double result = Double.parseDouble(s2 + s1) - Double.parseDouble(s1 + s2);
            if(result > 0) return 1;
            else if(result == 0) return 0;
            else return -1;
        });

        String result = "";
        for(int i=0; i<m; i++) {
            result = result+transfer[i];
        }

        int index = 0;
        for(int i=0; i<m; i++) {
            if(transfer[i].equals("0")) {
                index++;
            }
            else {
                break;
            }
        }

        result = result.substring(index);
        if(result.equals("")) {
            return "0";
        }

        return result;


    /*    if (nums == null || nums.length == 0) {
            return "";
        }
        

        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(array, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str2.compareTo(str1);
            }
        });

        if ("0".equals(array[0])) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }

        return sb.toString();*/

    }

}
