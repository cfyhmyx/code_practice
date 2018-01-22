//Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
//Each element is either an integer, or a list -- whose elements may also be integers or other lists.

import java.util.List;

public class Leetcode339 {
    public static void main(String args[]) {

    }

    private int result = 0;

    public int depthSum(List<NestedInteger> nestedList) {
        helper(nestedList, 1);
        return result;
    }

    private void helper(List<NestedInteger> nestedList, int dep) {
        for(int i=0; i<nestedList.size(); i++) {
            if(nestedList.get(i).isInteger()) {
                result += dep * nestedList.get(i).getInteger();
            } else {
                helper(nestedList.get(i).getList(), dep+1);
            }
        }
    }

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
