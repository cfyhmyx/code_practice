//On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.
//Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
//Return the smallest possible value of D.

import java.util.PriorityQueue;

public class Leetcode774 {
    public static void main(String args[]) {

    }

    public double minmaxGasDist(int[] st, int K) {
        int count, N = st.length;
        double left = 0, right = st[N - 1] - st[0], mid;

        while (left +1e-6 < right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < N - 1; ++i)
                count += Math.ceil((st[i + 1] - st[i]) / mid) - 1;
            if (count > K) left = mid;
            else right = mid;
        }
        return right;
    }

    /*private class Tuple {
        double init;
        int insertNum;
        double maxGap;
        public Tuple(double init, int insertNum, double maxGap) {
            this.init = init;
            this.insertNum = insertNum;
            this.maxGap = maxGap;
        }
    }

    public double minmaxGasDist(int[] stations, int K) {
        if(stations == null || stations.length == 0) return 0;
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b)->(b.maxGap-a.maxGap > 0 ? 1 : -1));
        for(int i=1; i<stations.length; i++) {
            queue.add(new Tuple(stations[i]-stations[i-1], 1, stations[i]-stations[i-1]));
        }
        double stop = (double)(stations[stations.length-1]-stations[0])/(double)(K+1);
        while(K>0) {
            Tuple tuple = queue.poll();
            do {
                tuple.insertNum++;
                tuple.maxGap = tuple.init/tuple.insertNum;
                K--;
            } while(K>0 && tuple.maxGap > stop);
            queue.add(tuple);
        }
        return queue.peek().maxGap;
    }*/

}
