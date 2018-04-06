//Given two lists Aand B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.
//We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
//These lists A and B may contain duplicates. If there are multiple answers, output any of them.

import java.util.*;

public class Leetcode760 {
    public static void main(String args[]) {
        int[] A = {12,28,46,32,50};
        int[] B = {50,12,32,46,28};
        int[] res = anagramMappings(A, B);
        for(int num : res) {
            System.out.println(num);
        }
    }

    public static int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<B.length; i++) {
            if(map.get(B[i]) == null) {
                map.put(B[i], new LinkedList<>());
            }
            map.get(B[i]).add(i);
        }
        int[] res = new int[A.length];
        for(int i=0; i<A.length; i++) {
            res[i] = map.get(A[i]).remove(0);
        }
        return res;
    }

}