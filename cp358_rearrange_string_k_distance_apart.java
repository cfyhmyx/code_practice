//Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
//All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

import java.util.*;

public class Leetcode358 {
    public static void main(String args[]) {
        String s = "aaaaabbbbbccccc";
        String result = rearrangeString(s, 3);
        System.out.println(result);
    }

    public static String rearrangeString(String s, int k) {
        StringBuilder rearranged = new StringBuilder();
        //count frequency of each char
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        //construct a max heap using self-defined comparator, which holds all Map entries, Java is quite verbose
        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue() == entry1.getValue() ? entry1.getKey()-entry2.getKey() : entry2.getValue() - entry1.getValue();
            }
        });

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();
        maxHeap.addAll(map.entrySet());

        while (!maxHeap.isEmpty()) {

            Map.Entry<Character, Integer> current = maxHeap.poll();
            rearranged.append(current.getKey());
            current.setValue(current.getValue() - 1);
            waitQueue.offer(current);

            if (waitQueue.size() < k) { // initial k-1 chars, waitQueue not full yet
                continue;
            }
            // release from waitQueue if char is already k apart
            Map.Entry<Character, Integer> front = waitQueue.poll();
            //note that char with 0 count still needs to be placed in waitQueue as a place holder
            if (front.getValue() > 0) {
                maxHeap.offer(front);
            }
        }

        return rearranged.length() == s.length() ? rearranged.toString() : "";
    }

}
