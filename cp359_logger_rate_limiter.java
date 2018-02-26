//Design a logger system that receive stream of messages along with its timestamps,
//each message should be printed if and only if it is not printed in the last 10 seconds.
//Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
//It is possible that several messages arrive roughly at the same time.

import java.util.*;

public class Leetcode359 {
    public static void main(String args[]) {
        Logger logger = new Logger();
        boolean test1 = logger.shouldPrintMessage(1, "foo");
        System.out.println(test1);
        boolean test2 = logger.shouldPrintMessage(11, "foo");
        System.out.println(test2);
    }

    static class Logger {

        HashMap<String, Integer> map;

        /** Initialize your data structure here. */
        public Logger() {
            map = new HashMap<>();
        }

        /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
         If this method returns false, the message will not be printed.
         The timestamp is in seconds granularity. */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if(!map.containsKey(message)) {
                map.put(message, timestamp);
                return true;
            }
            if(timestamp - map.get(message) < 10) {
                return false;
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }

}