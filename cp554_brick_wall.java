//https://leetcode.com/problems/brick-wall/description/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode554 {
    public static void main(String args[]) {

    }

    public static int leastBricks(List<List<Integer>> wall) {
        int maxsum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall) {
            int sum = 0;
            for(int i=0; i<row.size()-1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
                maxsum = Math.max(maxsum, map.get(sum));
            }
        }
        return wall.size()-maxsum;
    }
}
