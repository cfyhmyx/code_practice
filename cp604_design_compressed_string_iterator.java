//https://leetcode.com/problems/design-compressed-string-iterator/description/

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode604 {
    public static void main(String args[]) {
        StringIterator test = new StringIterator("x6");
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
        System.out.println(test.next());
    }

    static public class StringIterator {

        Queue<int[]> queue = new LinkedList<>();

        public StringIterator(String s) {
            int i = 0, n = s.length();
            while (i < n) {
                int j = i+1;
                while (j < n && s.charAt(j) - 'A' < 0) j++;
                queue.add(new int[]{s.charAt(i) - 'A',  Integer.parseInt(s.substring(i+1, j))});
                i = j;
            }
        }

        public char next() {
            if (queue.isEmpty()) return ' ';
            int[] top = queue.peek();
            if (--top[1] == 0) queue.poll();
            return (char) ('A' + top[0]);
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

    }

    /*static class StringIterator {

        private String expandString;
        private int index = -1;

        public StringIterator(String compressedString) {
            if(compressedString != null && compressedString.length() != 0) {
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<compressedString.length();) {
                    char cur = compressedString.charAt(i++);
                    String count = "";
                    while(i<compressedString.length() && compressedString.charAt(i)>='0' && compressedString.charAt(i)<='9') {
                        count += compressedString.charAt(i++);
                    }
                    int num = Integer.valueOf(count);
                    while(num>0) {
                        sb.append(cur);
                        num--;
                    }
                }
                expandString = sb.toString();
            }
        }

        public char next() {
            if(expandString == null || index+1>=expandString.length()) {
                return ' ';
            }
            return expandString.charAt(++index);
        }

        public boolean hasNext() {
            if(expandString == null || index+1>=expandString.length()) {
                return false;
            }
            return true;
        }
    }*/
}
