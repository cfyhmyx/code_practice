//description: https://leetcode.com/problems/factor-combinations/description/

import java.util.ArrayList;
import java.util.List;

public class Leetcode254 {
    public static void main(String args[]) {
        List<List<Integer>> result = getFactors(8);
        for(List<Integer> res : result) {
            System.out.print(res);
            System.out.println();
        }
    }

    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        helper(n, 2, res, list, (int) Math.sqrt(n));
        return res;
    }

    public static void helper(int n, int startIndex, List<List<Integer>> res, List<Integer> list, int sqrt) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            if (i > sqrt) {
                i = n;
            }
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, res, list, (int) Math.sqrt(n / i));
                list.remove(list.size() - 1);
            }
        }
    }

    /*public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), n, 2);
        return result;
    }

    public static void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n == 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }*/

}
