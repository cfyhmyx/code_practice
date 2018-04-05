//On the first row, we write a 0. Now in every subsequent row,
//we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

public class Leetcode779 {
    public static void main(String args[]) {

    }

    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        if (K % 2 == 0) return (kthGrammar(N - 1, K / 2) == 0) ? 1 : 0;
        else return (kthGrammar(N - 1, (K + 1) / 2) == 0) ? 0 : 1;
    }

}
