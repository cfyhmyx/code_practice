//description: https://leetcode.com/problems/beautiful-arrangement/description/
public class Leetcode526 {
    public static void main(String args[]) {
        int result = countArrangement(15);
        System.out.println(result);
    }

    static int total = 0;

    public static int countArrangement(int N) {
        boolean[] visit = new boolean[N];
        dfs(visit, 1);
        return total;
    }

    private static void dfs(boolean[] visit, int position) {
        if(position > visit.length){
            total++;
            return;
        }
        for(int i=1; i<=visit.length; i++) {        //better way: from back to start, since smaller numbers have higher chance to be divisible among themselves
            if(!visit[i-1] && isArranged(i, position)) {
                visit[i-1] = true;
                dfs(visit, position+1);
                visit[i-1] = false;
            }
        }
    }

    private static boolean isArranged(int num, int position) {
        if(num % position == 0 || position % num == 0) return true;
        return false;
    }
}
