//Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
import java.util.Arrays;
import java.util.Comparator;

public class Leetcode435 {
    public static void main(String args[]) {
        Interval in0 = new Interval(1,2);
        Interval in1 = new Interval(1,2);
        Interval in2 = new Interval(1,2);
        Interval in3 = new Interval(1,3);
        Interval[] intervals = {in0, in1, in2, in3};
        int result = eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public static int eraseOverlapIntervals(Interval[] intervals) {
        int result = 0;
        if(intervals.length<=1) return result;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval pre = intervals[0];
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start >= pre.end) {
                pre = intervals[i];
            } else {
                result++;
                if(intervals[i].end < pre.end) {
                    pre = intervals[i];
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
