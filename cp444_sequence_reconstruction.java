//Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
//The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
//Reconstruction means building a shortest common supersequence of the sequences in seqs
//(i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
//Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.

import java.util.*;

public class Leetcode444 {
    public static void main(String args[]) {
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(1,2));
        seqs.add(Arrays.asList(1,3));
        seqs.add(Arrays.asList(2,3));
        int[] org = {1,2,3};
        boolean result = sequenceReconstruction(org, seqs);
        System.out.println(result);
    }

    public static boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        for (List<Integer> seq : seqs) {
            for (int i = 0; i < seq.size(); i++) {
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
                indegree.putIfAbsent(seq.get(i), 0);
                if (i > 0) {
                    graph.get(seq.get(i-1)).add(seq.get(i));
                    indegree.put(seq.get(i), indegree.get(seq.get(i)) + 1);
                }
            }
        }
        if (org.length != indegree.size()) {
            return false;
        }

        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) {
                return false;
            }
            int curr = q.poll();
            if (org[index++] != curr) {
                return false;
            }
            for (int nb : graph.get(curr)) {
                indegree.put(nb, indegree.get(nb) - 1);
                if (indegree.get(nb) == 0) {
                    q.add(nb);
                }
            }
        }
        return index == org.length;
    }
}
