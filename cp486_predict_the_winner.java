//Given an array of scores that are non-negative integers.
//Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
//Each time a player picks a number, that number will not be available for the next player.
//This continues until all the scores have been chosen. The player with the maximum score wins.
//Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.

//explaination: from the prospective of one player, then what he/she gains each time is a plus,
//while, what the other player gains each time is a minus. Eventually if player1 can have a >0 total, player1 can win.
//complexity: n^2
//if e==s, there is no choice but have to select nums[s]
//otherwise, this current player has 2 options:
//--> nums[s]-helper(nums,s+1,e): this player select the front item, leaving the other player a choice from s+1 to e
//--> nums[e]-helper(nums,s,e-1): this player select the tail item, leaving the other player a choice from s to e-1
//Then take the max of these two options as this player's selection, return it.

public class Leetcode486 {
    public static void main(String args[]) {

    }

    public boolean PredictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length-1, new Integer[nums.length][nums.length])>=0;
    }
    private int helper(int[] nums, int s, int e, Integer[][] mem){
        if(mem[s][e]==null)
            mem[s][e] = s==e ? nums[e] : Math.max(nums[e]-helper(nums,s,e-1,mem),nums[s]-helper(nums,s+1,e,mem));
        return mem[s][e];
    }
    
}
