//https://leetcode.com/problems/couples-holding-hands/description/

public class Leetcode765 {
    public static void main(String args[]) {
        int[] row = {7,2,1,3,4,6,5,0};
        int result = minSwapsCouples(row);
        System.out.println(result);
    }

    private static int[] root;
    private static int[] rank;

    private static int find(int num) {
        if(num == root[num]){
            return num;
        }
        root[num] = find(root[num]);
        return root[num];
    }

    private static boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if(root1 == root2) return false;
        if(rank[root1] >= rank[root2]) {
            rank[root1] = rank[root1]==rank[root2] ? rank[root1]+1 : rank[root1];
            root[root2] = root1;
        } else {
            root[root1] = root2;
        }
        return true;
    }

    public static int minSwapsCouples(int[] row) {
        int n = row.length;
        root = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++) {
            root[i] = i%2 == 0 ? i : i-1;
            rank[i] = i%2 == 0 ? 1 : 0;
        }
        int result = 0;
        for(int i=0; i<n; i+=2) {
            if(union(row[i], row[i+1])){
                result++;
            }
        }
        return result;
    }


    /*public static int minSwapsCouples(int[] row) {
        int res = 0, N = row.length;

        int[] ptn = new int[N];
        int[] pos = new int[N];

        for (int i = 0; i < N; i++) {
            ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
            pos[row[i]] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]) {
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                res++;
            }
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }*/

}
