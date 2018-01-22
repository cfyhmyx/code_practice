//Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode364 {
    public static void main(String args[]) {

    }

    class ds {
        public int val;
        public int dep;
        public ds(int val, int dep) {
            this.val = val;
            this.dep = dep;
        }
    }

    private int maxdep = Integer.MIN_VALUE;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<ds> arr =new ArrayList<>();
        helper(nestedList, arr, 0);
        int result = 0;
        for(int i=0; i<arr.size(); i++) {
            result += (maxdep-arr.get(i).dep+1)*arr.get(i).val;
        }
        return result;
    }

    private void helper(List<NestedInteger> nestedList, List<ds> arr, int dep) {
        maxdep = Math.max(maxdep, dep);
        for(int i=0; i<nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                arr.add(new ds(nestedList.get(i).getInteger(), dep));
            } else {
                helper(nestedList.get(i).getList(), arr, dep+1);
            }
        }
    }

    //easier method
    /*public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, weighted = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLevel = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger())
                    unweighted += ni.getInteger();
                else
                    nextLevel.addAll(ni.getList());
            }
            weighted += unweighted;
            nestedList = nextLevel;
        }
        return weighted;
    }*/

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
    }

}
