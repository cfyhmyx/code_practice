//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

public class Leetcode096 {
    public static void main(String args[]) {
        int result = numTrees(4);
        System.out.println(result);
    }

    public static int numTrees(int n) {
        if(n<=1) return 1;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        int index = 2;
        while (index <= n) {
            for (int i = 0; i < index; i++) {
                arr[index] += arr[i] * arr[index - 1 - i];
            }
            index++;
        }
        return arr[n];
    }

}
