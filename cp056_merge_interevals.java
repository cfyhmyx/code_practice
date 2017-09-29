//Given a collection of intervals, merge all overlapping intervals.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leetcode056 {
    public static void main(String args[]) {
        Interval in1 = new Interval(1,3);
        Interval in2 = new Interval(2,6);
        Interval in3 = new Interval(8,10);
        Interval in4 = new Interval(7,9);
        Interval in5 = new Interval(13,19);
        Interval in6 = new Interval(12,18);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);
        intervals.add(in5);
        intervals.add(in6);
        List<Interval> result = merge(intervals);
        for(Interval in : result) {
            System.out.println("[" + in.start + "," + in.end + "]");
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals.isEmpty()) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        result.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++) {
            Interval cur =result.get(result.size()-1);
            if(intervals.get(i).start > cur.end) {
                result.add(intervals.get(i));
            } else if (cur.end < intervals.get(i).end){
                cur.end = intervals.get(i).end;
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
