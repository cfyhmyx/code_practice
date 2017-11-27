//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

import java.util.*;

public class Leetcode252 {
    public static void main(String args[]) {
        Interval in1 = new Interval(3,10);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(15,20);
        Interval[] intervals = {in1, in2, in3};
        boolean result = canAttendMeetings(intervals);
        System.out.println(result);
    }

    public static boolean canAttendMeetings(Interval[] intervals) {
        if(intervals.length <= 1) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
