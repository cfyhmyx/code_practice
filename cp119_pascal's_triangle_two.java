//Given an index k, return the kth row of the Pascal's triangle.

import java.util.ArrayList;
import java.util.List;

public class Leetcode119 {
    public static void main(String args[]) {
        List<Integer> result = getRow(3);
        System.out.println(result);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=rowIndex; i++) {
            list.add(0, 1);
            for(int j=1; j<list.size()-1; j++) {
                list.set(j, list.get(j)+list.get(j+1));
            }
        }
        return list;
    }
}