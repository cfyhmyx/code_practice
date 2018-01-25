//A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
//description: https://leetcode.com/problems/range-module/description/.

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
}
