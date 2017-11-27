//A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
//description: https://leetcode.com/problems/range-module/description/.

import java.util.*;

public class Leetcode715 {
    public static void main(String args[]) {
        RangeModule test = new RangeModule();
        test.addRange(10,20);
        test.removeRange(14,16);
        boolean result = test.queryRange(10,14);
        System.out.println(result);
    }

    static class RangeModule {

        private TreeMap<Integer, Integer> map;
        public RangeModule() {
            map = new TreeMap<>();
        }

        public void addRange(int left, int right) {
            if(right <= left) return;
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if (entry != null && entry.getValue() >= left) {
                map.remove(entry.getKey());
                left = entry.getKey();
                right = Math.max(right, entry.getValue());
            }
            while (true) {
                entry = map.higherEntry(left);
                if (entry == null || entry.getKey() > right) {
                    break;
                }
                map.remove(entry.getKey());
                right = Math.max(right, entry.getValue());
            }
            map.put(left, right);
        }

        public boolean queryRange(int left, int right) {
            Map.Entry<Integer, Integer> lowerEntry = map.floorEntry(left);
            return lowerEntry != null && lowerEntry.getValue() >= right;
        }

        public void removeRange(int left, int right) {
            if(right<=left) return;
            Map.Entry<Integer, Integer> entry = map.floorEntry(left);
            if (entry != null && entry.getValue() > left) {
                map.remove(entry.getKey());
                map.put(entry.getKey(), left);
                if (entry.getValue() > right) {
                    map.put(right, entry.getValue());
                }
            }
            while (true) {
                entry = map.ceilingEntry(left);
                if (entry == null || entry.getKey() >= right) {
                    break;
                }
                map.remove(entry.getKey());
                if (entry.getValue() > right) {
                    map.put(right, entry.getValue());
                }
            }
        }

    }
}
