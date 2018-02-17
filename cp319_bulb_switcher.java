//There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb.
//On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on).
//For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb.
//Find how many bulbs are on after n rounds.

public class Leetcode319 {
    public static void main(String args[]) {
        int result = bulbSwitch(2);
        System.out.println(result);
    }

    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    /*public static int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        int round = 0;
        while(round<n) {
            for(int i=round; i<n; i = i+round+1) {
                bulbs[i] = !bulbs[i];
            }
            round++;
        }
        int result = 0;
        for(boolean bulb : bulbs) {
            if(bulb) result++;
        }
        return result;
    }*/
}
