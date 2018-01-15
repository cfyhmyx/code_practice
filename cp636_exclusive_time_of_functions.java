//https://leetcode.com/problems/exclusive-time-of-functions/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode636 {
    public static void main(String args[]) {
        ArrayList<String> logs = new ArrayList<>();
        logs.add("0:start:0");
        logs.add("1:start:2");
        logs.add("1:end:5");
        logs.add("0:end:6");
        int[] result = exclusiveTime(2, logs);
        for(int num : result) {
            System.out.println(num);
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) res[stack.peek()] += Integer.parseInt(parts[2]) - prevTime;
            prevTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                res[stack.pop()]++;
                prevTime++;
            }
        }
        return res;
    }

}
