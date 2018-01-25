//Given a string, determine if a permutation of the string could form a palindrome.
//For example, "code" -> False, "aab" -> True, "carerac" -> True.

public class Leetcode266 {
    public static void main(String args[]) {
        boolean result = canPermutePalindrome("carerac");
        System.out.println(result);
    }

    public static boolean canPermutePalindrome(String s) {
        int[] map = new int[256];
        for(char ch : s.toCharArray()) {
            map[ch]++;
        }
        int numOfsingle = 0;
        for(int i=0; i<256; i++) {
            if(map[i]%2 == 1) {
                numOfsingle++;
                if(numOfsingle>1) {
                    return false;
                }
            }
        }
        return true;
    }

}
