//https://leetcode.com/problems/my-calendar-i/description/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Leetcode729 {
    public static void main(String args[]) {
        MyCalendar test = new MyCalendar();
        boolean book1 = test.book(10,20);
        System.out.println(book1);
        boolean book2 = test.book(15,25);
        System.out.println(book2);
        boolean book3 = test.book(20,30);
        System.out.println(book3);
    }

    //O(logn)
    static class MyCalendar {

        private TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            if(start>=end)return false;
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(start);
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(start);
            if(floorEntry != null && floorEntry.getValue()>start || ceilingEntry!=null && ceilingEntry.getKey()<end) {
                return false;
            }
            map.put(start, end);
            return true;
        }
    }

    //O(n), more space
    /*static class MyCalendar {

        private List<int[]> list;

        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for(int[] time : list) {
                if (time[0] < end && start < time[1]) return false;
            }
            list.add(new int[]{start, end});
            return true;
        }
    }*/
}
