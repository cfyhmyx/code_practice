//https://leetcode.com/problems/reconstruct-itinerary/description/

import java.util.*;

public class Leetcode332 {
    public static void main(String args[]) {

    }

    private static Map<String, PriorityQueue<String>> flights;
    private static LinkedList<String> path;

    public static List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public static void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}
