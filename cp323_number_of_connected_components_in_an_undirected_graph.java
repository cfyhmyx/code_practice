//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
//write a function to find the number of connected components in an undirected graph.

import java.util.*;

public class Leetcode323 {
    public static void main(String args[]) {
        int[][] edges = {{0,1},{1,2},{3,4},{5,6}};
        int result = countComponents(7,edges);
        System.out.println(result);
    }

    public static int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    visited[index] = true;
                    for (int next : adjList.get(index)) {
                        if (!visited[next]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        return count;
    }


    //*************************************************DFS
    /*public static int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }

        return count;
    }

    public static void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }*/


    //***********************************************union and find
    /*private static int[] rank;
    private static int[] parent;

    public static int countComponents(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(union(edge[0], edge[1])){
                n--;
            }
        }
        return n;
    }

    private static boolean union(int num1, int num2) {
        int parent1 = find(num1);
        int parent2 = find(num2);
        if(parent1 == parent2) {
            return false;
        }
        if(rank[parent1]>=rank[parent2]){
            rank[parent1] = rank[parent1]==rank[parent2] ? rank[parent1]++ : rank[parent1];
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
        return true;
    }

    private static int find(int num) {
        if(num == parent[num]){
            return num;
        }
        parent[num] = find(parent[num]);
        return parent[num];
    }*/


    //****************************************traditional union and find
    /*private static Map<Integer, Node> map = new HashMap<>();

    static class Node {
        int value;
        Node parent;
        int rank;
    }

    private static void createNode(int value) {
        Node node = new Node();
        node.value = value;
        node.parent = node;
        node.rank = 0;
        map.put(value, node);
    }

    private static Node find(Node node) {
        Node parent = node.parent;
        if(node == parent) {
            return node;
        }
        node.parent = find(node.parent);
        return node.parent;
    }

    private static boolean union(Node node1, Node node2) {
        Node parent1 = find(node1);
        Node parent2 = find(node2);
        if(parent1 == parent2) {
            return false;
        }
        if(parent1.rank >= parent2.rank) {
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank+1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
        return true;
    }

    public static int countComponents(int n, int[][] edges) {
        if(edges.length == 0) return 0;
        for(int i=0; i<edges.length; i++) {
            if(!map.containsKey(edges[i][0])) {
                createNode(edges[i][0]);
            }
            if(!map.containsKey(edges[i][1])) {
                createNode(edges[i][1]);
            }
            if(union(map.get(edges[i][0]), map.get(edges[i][1]))) {
                n--;
            }
        }
        return n;
    }*/
}
