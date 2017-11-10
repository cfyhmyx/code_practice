//Given an array of characters, compress it in-place.
//The length after compression must always be smaller than or equal to the original array.
//Every element of the array should be a character (not int) of length 1.
//After you are done modifying the input array in-place, return the new length of the array.

public class Leetcode443 {
    public static void main(String args[]) {
        char[] chars = {'a'};
        int result = compress(chars);
        System.out.println(result);
    }

    public static int compress(char[] chars) {
        if(chars.length == 0) return 0;
        int index = 0;
        char cur = chars[0];
        int count = 1;
        for(int i=1; i<chars.length; i++) {
            if(chars[i] == cur) {
                count++;
            } else {
                chars[index++] = cur;
                if(count != 1) {
                    String num = "" + count;
                    for (int j = 0; j < num.length(); j++) {
                        chars[index++] = num.charAt(j);
                    }
                }
                cur = chars[i];
                count = 1;
            }
        }
        chars[index++] = cur;
        if(count != 1) {
            String num = "" + count;
            for (int j = 0; j < num.length(); j++) {
                chars[index++] = num.charAt(j);
            }
        }
        return index;
    }
}
