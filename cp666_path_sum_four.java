//https://leetcode.com/problems/path-sum-iv/description/

public class Leetcode666 {
    public static void main(String args[]) {
        int[] nums = {113};
        int result = pathSum(nums);
        System.out.println(result);
    }

    private static int result = 0;

    public static int pathSum(int[] nums) {
        int[] tree = new int[32];
        for(int i=0; i<32; i++) {
            tree[i] = -1;
        }
        for(int num : nums) {
            int index = (int)Math.pow(2, num/100-1)+(num%100)/10-1;
            tree[index] = num%10;
        }
        if(tree[1] == -1) return 0;
        helper(tree, 1, tree[1]);
        return result;
    }

    private static void helper(int[] tree, int index, int path) {
        if(tree[2*index] == -1 && tree[2*index+1] == -1) {
            result += path;
            return;
        }
        if(tree[2*index] != -1) {
            helper(tree, 2*index, path+tree[2*index]);
        }
        if(tree[2*index+1] != -1) {
            helper(tree, 2*index+1, path+tree[2*index+1]);
        }
    }
}
