//https://leetcode.com/problems/my-calendar-ii/description/

import java.util.Map;
import java.util.TreeMap;

public class Leetcode731 {
    public static void main(String args[]) {
        MyCalendarTwo test = new MyCalendarTwo();
        boolean book1 = test.book(28,46);
        System.out.println(book1);
        boolean book2 = test.book(9,21);
        System.out.println(book2);
        boolean book3 = test.book(21,39);
        System.out.println(book3);
        boolean book4 = test.book(37,48);
        System.out.println(book4);
        boolean book5 = test.book(38,50);
        System.out.println(book5);
        boolean book6 = test.book(45,50);
        System.out.println(book6);
    }

    //O(logn)
    static class MyCalendarTwo {

        private TreeMap<Integer, Integer> map1;
        private TreeMap<Integer, Integer> map2;

        public MyCalendarTwo() {
            map1 = new TreeMap<>();
            map2 = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if(start>=end) return false;
            Map.Entry<Integer, Integer> floorEntry1 = map1.floorEntry(start);
            Map.Entry<Integer, Integer> ceilingEntry1 = map1.ceilingEntry(start);
            Map.Entry<Integer, Integer> floorEntry2 = map2.floorEntry(start);
            Map.Entry<Integer, Integer> ceilingEntry2 = map2.ceilingEntry(start);
            if(floorEntry1 != null && floorEntry1.getValue()>start || ceilingEntry1!=null && ceilingEntry1.getKey()<end) {
                if(floorEntry2 != null && floorEntry2.getValue()>start || ceilingEntry2!=null && ceilingEntry2.getKey()<end) {
                    return false;
                }
                int doubleStart = start;
                int doubleEnd = end;
                if (floorEntry1 != null && floorEntry1.getValue() > start) {
                    map1.remove(floorEntry1.getKey());
                    doubleEnd = Math.min(end, floorEntry1.getValue());
                    map2.put(doubleStart, doubleEnd);
                    start = floorEntry1.getKey();
                    end = Math.max(end, floorEntry1.getValue());
                }
                ceilingEntry1 = map1.ceilingEntry(start);
                while (ceilingEntry1!=null && ceilingEntry1.getKey()<end) {
                    map1.remove(ceilingEntry1.getKey());
                    map2.put(ceilingEntry1.getKey(), Math.min(end, ceilingEntry1.getValue()));
                    end = Math.max(end, ceilingEntry1.getValue());
                    ceilingEntry1 = map1.ceilingEntry(start);
                }
            }
            map1.put(start, end);
            return true;
        }
    }

    //O(n), more space
    /*class MyCalendarTwo {
        List<int[]> calendar;
        List<int[]> overlaps;

        MyCalendarTwo() {
            calendar = new ArrayList();
            overlaps = new ArrayList();
        }

        public boolean book(int start, int end) {
            for (int[] iv: overlaps) {
                if (iv[0] < end && start < iv[1]) return false;
            }
            for (int[] iv: calendar) {
                if (iv[0] < end && start < iv[1])
                    //only consider the minimum interval as the overlapped area
                    overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
            }
            calendar.add(new int[]{start, end});
            return true;
        }
    }*/
}
