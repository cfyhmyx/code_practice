//Equations are given in the format A / B = k, where A and B are variables represented as strings,
//and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Leetcode399 {
    public static void main(String args[]) {

    }

    HashMap<String, List<GraphNode>> map;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for(int i=0; i<equations.length; i++) {
            String[] equation = equations[i];
            if(!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if(!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1/values[i]));
        }
        double[] res = new double[queries.length];
        for(int i=0; i<res.length; i++) {
            res[i] = dfs(queries[i][0], queries[i][1], 1, new HashSet<>());
        }
        return res;
    }

    private double dfs(String start, String end, double value, HashSet<String> visited) {
        if(visited.contains(start)) return -1;
        if(!map.containsKey(start)) return -1;
        if(start.equals(end)) return value;
        visited.add(start);
        for(GraphNode next : map.get(start)) {
            double sub = dfs(next.div, end, value*next.val, visited);
            if(sub != -1.0) return sub;
        }
        visited.remove(start);
        return -1;
    }

    class GraphNode {
        String div;
        double val;
        GraphNode(String div, double val) {
            this.div = div;
            this.val = val;
        }
    }

}
