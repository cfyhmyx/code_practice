//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
//write a function to check whether these edges make up a valid tree.

public class Leetcode261 {
    public static void main(String args[]) {
        int[][] edges = {{0,1},{1,2},{2,3},{1,3},{1,4}};
        boolean result = validTree(5, edges);
        System.out.println(result);
    }

    private static int[] rank;
    private static int[] parent;

    private static boolean union(int num1, int num2) {
        int parent1 = find(num1);
        int parent2 = find(num2);
        if(parent1 == parent2) {
            return false;
        }
        if(rank[parent1]>=rank[parent2]){
            rank[parent1] = rank[parent1] == rank[parent2] ? rank[parent1]+1 : rank[parent1];
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
        return true;
    }

    private static int find(int num1) {
        if(num1 == parent[num1]) {
            return num1;
        }
        parent[num1] = find(parent[num1]);
        return parent[num1];
    }

    public static boolean validTree(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        for(int[] edge : edges) {
            if(union(edge[0], edge[1])){
                n--;
            } else {
                return false;
            }
        }
        return n==1;
    }

}
