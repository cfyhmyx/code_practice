//description: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode373 {
    public static void main(String args[]) {
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        List<int[]> result = kSmallestPairs(nums1, nums2, 3);
        for(int[] res : result) {
            for(int i=0; i<res.length; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1.length < 1 || nums2.length<1 || k<1) return result;
        PriorityQueue<Ds> heap = new PriorityQueue<>();
        for(int index2=0; index2<nums2.length; index2++) {
            heap.add(new Ds(0, index2, nums1[0] + nums2[index2]));
        }
        for(int i=0; i<Math.min(k,nums1.length*nums2.length); i++) {
            Ds cur = heap.poll();
            result.add(new int[]{nums1[cur.index1], nums2[cur.index2]});
            if(cur.index1 == nums1.length-1) continue;
            heap.add(new Ds(cur.index1+1, cur.index2, nums1[cur.index1+1]+nums2[cur.index2]));
        }
        return result;
    }

    static class Ds implements Comparable<Ds> {
        int index1;
        int index2;
        int sum;
        public Ds(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }

        @Override
        public int compareTo(Ds that) {
            return this.sum-that.sum;
        }
    }

}
