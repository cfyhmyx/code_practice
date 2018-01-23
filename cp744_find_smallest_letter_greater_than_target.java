//Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
//(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

public class Leetcode744 {
    public static void main(String args[]) {
        char[] letters = {'a','b'};
        char res = nextGreatestLetter(letters, 'z');
        System.out.println(res);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int low = 0, high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (letters[mid] > target)     high = mid-1;
            else    low = mid + 1;
        }
        return letters[low%n];
    }

    /*public static char nextGreatestLetter(char[] letters, char target) {
        char res = 'a';
        int dis = Integer.MAX_VALUE;
        for(char ch : letters) {
            char temp = ch;
            if(ch <= target){
                temp = (char)(ch + 26);
            }
            if((temp - target)<dis) {
                dis = temp-target;
                res = ch;
            }
        }
        return res;
    }*/
}
