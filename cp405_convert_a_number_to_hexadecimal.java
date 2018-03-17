//Find the sum of all left leaves in a given binary tree.

public class Leetcode405 {
    public static void main(String args[]) {
        String result = toHex(-1);
        System.out.println(result);
    }

    private static char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result;
            num = (num >>> 4);
        }
        return result;
    }

}
