//Given numRows, generate the first numRows of Pascal's triangle.

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
    public static void main(String args[]) {
        List<List<Integer>> result = generate(5);
        System.out.println(result);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numRows; i++) {
            list.add(0, 1);
            for(int j=1; j<list.size()-1; j++) {
                list.set(j, list.get(j)+list.get(j+1));
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    /*public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1; i<=numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i, 0));
            row.set(0, 1);
            row.set(i-1, 1);
            for(int j=1; j<i-1; j++) {
                int cur = result.get(i-2).get(j-1) + result.get(i-2).get(j);
                row.set(j,cur);
            }
            result.add(row);
        }
        return result;
    }*/
}
