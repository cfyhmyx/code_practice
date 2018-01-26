//https://leetcode.com/problems/my-calendar-iii/discuss/109556

import java.util.TreeMap;

public class Leetcode732 {
    public static void main(String args[]) {
        MyCalendarThree test = new MyCalendarThree();
        int book1 = test.book(10,20);
        System.out.println(book1);
        int book2 = test.book(50,60);
        System.out.println(book2);
        int book3 = test.book(10,40);
        System.out.println(book3);
        int book4 = test.book(5,15);
        System.out.println(book4);
        int book5 = test.book(5,10);
        System.out.println(book5);
        int book6 = test.book(25,55);
        System.out.println(book6);
    }

    static class MyCalendarThree {
        private TreeMap<Integer, Integer> timeline = new TreeMap<>();
        public int book(int s, int e) {
            timeline.put(s, timeline.getOrDefault(s, 0) + 1); // 1 new event will be starting at [s]
            timeline.put(e, timeline.getOrDefault(e, 0) - 1); // 1 new event will be ending at [e];
            int ongoing = 0, k = 0;
            for (int v : timeline.values())
                k = Math.max(k, ongoing += v);
            return k;
        }
    }

}
