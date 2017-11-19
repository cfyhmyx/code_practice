//There are a total of n courses you have to take, labeled from 0 to n - 1.
//Some courses may have prerequisites, for example to take course 0 you have to first take course 1,which is expressed as a pair: [0,1]
//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode210 {
    public static void main(String args[]) {
        int[][] edges = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = findOrder(4, edges);
        for(int course : result) {
            System.out.println(course);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        int index = 0;
        while(queue.size() != 0){
            int course = (int)queue.poll();
            result[index++] = course;
            for(int i=0; i<graph[course].size();i++){
                int next = (int)graph[course].get(i);
                degree[next]--;
                if(degree[next] == 0){
                    queue.add(next);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return result;
        else
            return new int[]{};
    }
}
