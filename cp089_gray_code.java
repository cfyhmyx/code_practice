//https://leetcode.com/problems/gray-code/description/

import java.util.ArrayList;
import java.util.List;

public class Leetcode089 {
    public static void main(String args[]) {

    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<1<<n; i++) {
            res.add(i^i>>1);
        }
        return res;
    }
}
