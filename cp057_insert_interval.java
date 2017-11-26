//Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//You may assume that the intervals were initially sorted according to their start times.

import java.util.ArrayList;
import java.util.List;

public class Leetcode057 {
    public static void main(String args[]) {
        Interval in1 = new Interval(1,3);
        Interval in2 = new Interval(4,6);
        Interval in3 = new Interval(7,9);
        Interval in4 = new Interval(11,12);
        Interval in5 = new Interval(13,19);
        Interval newInterval = new Interval(12,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        intervals.add(in5);
        List<Interval> result = insert(intervals, newInterval);
        for(Interval in : result) {
            System.out.println("[" + in.start + "," + in.end + "]");
        }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        result.add(newInterval);
        for(int i=0; i<intervals.size(); i++) {
            Interval cur =result.get(result.size()-1);
            if(intervals.get(i).end < cur.start) {
                result.add(result.size()-1,intervals.get(i));
            } else if(intervals.get(i).start > cur.end) {
                result.add(intervals.get(i));
            } else {
                if(cur.start > intervals.get(i).start) {
                    cur.start = intervals.get(i).start;
                }
                if (cur.end < intervals.get(i).end) {
                    cur.end = intervals.get(i).end;
                }
            }
        }
        return result;
    }

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
