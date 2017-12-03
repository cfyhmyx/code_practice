//https://leetcode.com/problems/can-i-win/description/

//explaination: https://discuss.leetcode.com/topic/68896/java-solution-using-hashmap-with-detailed-explanation/2?page=1

import java.util.Arrays;
import java.util.HashMap;

public class Leetcode464 {
    public static void main(String args[]) {

    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, new int[maxChoosableInteger], new HashMap<>());
    }
    private boolean canIWin(int total, int[] state, HashMap<String, Boolean> hashMap) {
        String curr = Arrays.toString(state);
        if (hashMap.containsKey(curr)) return hashMap.get(curr);
        for (int i=0;i<state.length;i++) {
            if (state[i]==0) {
                state[i]=1;
                if (total<=i+1 || !canIWin(total-(i+1), state, hashMap)) {
                    hashMap.put(curr, true);
                    state[i]=0;
                    return true;
                }
                state[i]=0;
            }
        }
        hashMap.put(curr, false);
        return false;
    }

    /*public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal<=0) return true;
        if (maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal) return false;
        return canIWin(desiredTotal, maxChoosableInteger, 0, new HashMap<>());
    }
    private boolean canIWin(int total, int n, int state, HashMap<Integer, Boolean> hashMap) {
        if (hashMap.containsKey(state)) return hashMap.get(state);
        for (int i=0;i<n;i++) {
            if ((state&(1<<i))!=0) continue;
            if (total<=i+1 || !canIWin(total-(i+1), n, state|(1<<i), hashMap)) {
                hashMap.put(state, true);
                return true;
            }
        }
        hashMap.put(state, false);
        return false;
    }*/
}
