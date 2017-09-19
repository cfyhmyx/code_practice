//description: https://leetcode.com/problems/longest-absolute-file-path/description/
import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode388 {
    public static void main(String args[]) {
        //"dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
        int result = lengthLongestPath("dir\n\ta\n\t\tb.c");
        System.out.println(result);
    }

    public static int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s:input.split("\n")){
            int lev = s.lastIndexOf("\t")+1; // number of "\t"
            while(lev+1<stack.size()) stack.pop(); // find parent
            int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            if(s.contains(".")) maxLen = Math.max(maxLen, len-1); //remove the final '/'
        }
        return maxLen;
    }

    //better way
    /*public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf("\t")+1;
            int curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;
            if(s.contains("."))
                maxLen = Math.max(maxLen, curLen-1);
        }
        return maxLen;
    }*/

}
