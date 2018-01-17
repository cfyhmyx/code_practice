//Given a string and an integer k, you need to reverse the first k characters for every 2k characters
//counting from the start of the string. If there are less than k characters left, reverse all of them.
//If there are less than 2k but greater than or equal to k characters,
//then reverse the first k characters and left the other as original.

public class Leetcode541 {
    public static void main(String args[]) {

    }

    public static String reverseStr(String s, int k) {
        char[] arr =s.toCharArray();
        for(int i=0; i<arr.length; i+=2*k) {
            int low = i;
            int high = Math.min(arr.length-1, i+k-1);
            while(low<high) {
                char temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return new String(arr);
    }

}
