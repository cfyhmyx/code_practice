//Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
//where h is the height of the person and k is the number of people in front of this person
//who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Leetcode406 {
    public static void main(String args[]) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = reconstructQueue(people);
        for(int i=0; i< result.length; i++) {
            System.out.print(result[i][0]);
            System.out.print(" ");
            System.out.println(result[i][1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        int m = people.length;
        if(m==0) return new int[0][];
        int[][] result = new int[m][2];
        List<int[]> listResult = new LinkedList<>();
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0]-o2[0];
                else return o1[1] - o2[1];
            }
        });
        listResult.add(people[0]);
        for(int i=1; i<m; i++) {
            int value = people[i][0];
            int count = people[i][1];
            int j=0;
            for(; j<listResult.size(); j++){
                if(value <= listResult.get(j)[0]) {
                    if(count == 0) {
                        break;
                    }
                    count--;
                }
            }
            listResult.add(j, people[i]);
        }
        for(int i=0; i<m; i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }

    //better way
    /*public int[][] reconstructQueue(int[][] people) {
        //pick up the tallest guy first
        //when insert the next tall guy, just need to insert him into kth position
        //repeat until all people are inserted into list
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]!=o2[0]?-o1[0]+o2[0]:o1[1]-o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for(int[] cur : people){
            res.add(cur[1],cur);
        }
        return res.toArray(new int[people.length][]);
    }*/
}
