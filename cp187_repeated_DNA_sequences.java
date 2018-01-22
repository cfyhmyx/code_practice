//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
//When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode187 {
    public static void main(String args[]) {

    }

    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++) {
            String cur = s.substring(i, i+10);
            if(!seen.add(cur)) {
                repeated.add(cur);
            }
        }
        return new ArrayList<>(repeated);
    }

}
