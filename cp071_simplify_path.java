//Given an absolute path for a file (Unix-style), simplify it.

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode071 {
    public static void main(String args[]) {

    }

    public String simplifyPath(String path) {
        if(path.length() == 0) return "";
        Deque<String> queue = new LinkedList<>();
        int index = 0;
        while(index<path.length()) {
            while(index<path.length() && path.charAt(index) == '/'){
                index++;
            }
            if(index == path.length()) break;
            int endIndex = path.indexOf('/', index) == -1 ? path.length() : path.indexOf('/', index);
            if(endIndex-index>0) {
                String pattern = path.substring(index, endIndex);
                if(pattern.equals(".")){}
                else if(pattern.equals("..")) {
                    if(!queue.isEmpty()) {
                        queue.removeLast();
                    }
                } else {
                    queue.add(pattern);
                }
            }
            index = endIndex+1;
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append('/').append(queue.poll());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
