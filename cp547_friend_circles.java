//There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature.
//For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C.
//And we defined a friend circle is a group of students who are direct or indirect friends.
//Given a N*N matrix M representing the friend relationship between students in the class.
//If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not.
//And you have to output the total number of friend circles among all the students.

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Leetcode547 {
    public static void main(String args[]) {
        int[][] M = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1},{1,0,1,1}};
        int result = findCircleNum(M);
        System.out.println(result);
    }

    private static int[] rank;
    private static int[] parent;

    public static int findCircleNum(int[][] M) {
        int n = M.length;
        rank = new int[n];
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        int result = n;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(M[i][j] == 1 && union(i, j)){
                    result--;
                }
            }
        }
        return result;
    }

    private static boolean union(int num1, int num2) {
        int parent1 = find(num1);
        int parent2 = find(num2);
        if(parent1 == parent2) return false;
        if(rank[parent1] >= rank[parent2]){
            rank[parent1] = rank[parent1]==rank[parent2] ? rank[parent1]+1 : rank[parent1];
            parent[parent2] = parent1;
        } else {
            parent[parent1] = parent2;
        }
        return true;
    }

    private static int find(int num) {
        if(num == parent[num]) {
            return num;
        }
        parent[num] = find(parent[num]);
        return parent[num];
    }

    //bfs
    /*public static int findCircleNum(int[][] M) {
        int result = 0;
        if(M.length == 0) return result;
        int m = M.length;
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<m; i++) {
            if(s.contains(i)) continue;
            s.add(i);
            Queue circle = new LinkedList();
            circle.add(i);
            while(!circle.isEmpty()) {
                int cur = (int)circle.poll();
                for(int j=0; j<m; j++) {
                    if(M[cur][j] == 1 && !s.contains(j)) {
                        s.add(j);
                        circle.add(j);
                    }
                }
            }
            result++;
        }
        return result;
    }*/

    //dfs
    /*public int findCircleNum(int[][] M) {
        boolean[] isVisit = new boolean[M.length];
        int count = 0;
        for (int i=0;i<M.length;i++) {
            if (!isVisit[i]) {
                count++;
                helper(M,isVisit,i);
            }
        }
        return count;
    }
    private void helper(int[][] M, boolean[] isVisit,int i) {
        if (isVisit[i]) {
            return;
        }
        isVisit[i] = true;
        for (int j=0;j<M[0].length;j++) {
            if (M[i][j] == 1) {
                helper(M,isVisit,j);
            }
        }
    }*/
}
