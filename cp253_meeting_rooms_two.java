//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Leetcode253 {
    public static void main(String args[]) {
        Interval in1 = new Interval(9,16);
        Interval in2 = new Interval(6,16);
        Interval in3 = new Interval(1,9);
        Interval in4 = new Interval(3,15);
        Interval[] intervals = {in1, in2, in3, in4};
        int result = minMeetingRooms(intervals);
        System.out.println(result);
    }

    public static int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 1) return 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Interval interval : intervals) {
            map.put(interval.start, map.getOrDefault(interval.start, 0)+1);
            map.put(interval.end, map.getOrDefault(interval.end, 0)-1);
        }
        int room = 0;
        int meeting = 0;
        for(int val : map.values()) {
            meeting += val;
            room = Math.max(room, meeting);
        }
        return room;
    }

    /*public static int minMeetingRooms(Interval[] intervals) {
        if(intervals.length < 1) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        PriorityQueue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.end-o2.end;
            }
        });
        queue.offer(intervals[0]);
        int result = 1;
        for(int i=1; i<intervals.length; i++) {
            if(intervals[i].start < queue.peek().end) {
                result++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i]);
        }
        return result;
    }*/

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
