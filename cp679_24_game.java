//Implement a magic directory with buildDict, and search methods.
//For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
//For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word,
//the modified word is in the dictionary you just built.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode679 {

    public static void main(String args[]) {

    }

    private double eps = 0.001;

    public boolean judgePoint24(int[] nums) {
        List<Double> operands = new ArrayList<>();
        for(int num : nums)
            operands.add((double) num);
        return judgePoint24(operands);
    }

    private boolean judgePoint24(List<Double> operands){
        if(operands.size() == 1) {
            return Math.abs(operands.get(0) - 24.0) < eps;
        }
        for(int i = 0; i < operands.size() - 1; i++){
            for(int j = i+1; j < operands.size(); j++){
                double o1 = operands.get(i);
                double o2 = operands.get(j);
                List<Double> combinesO1O2 = new ArrayList<>(); //all possible results of combining o1 & o2
                combinesO1O2.addAll(Arrays.asList(o1+o2, o1-o2, o2-o1, o1*o2));
                if(Math.abs(o1) > eps) combinesO1O2.add(o2/o1);
                if(Math.abs(o2) > eps) combinesO1O2.add(o1/o2);

                operands.remove(j);
                operands.remove(i);
                for(double combine : combinesO1O2){
                    operands.add(combine);
                    if(judgePoint24(operands))
                        return true;
                    operands.remove(operands.size()-1);
                }
                operands.add(i, o1);
                operands.add(j, o2);
            }
        }
        return false;
    }

}
