//description: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/

public class Leetcode331 {
    public static void main(String args[]) {
        String preorder = "9,#,92,#,#";
        boolean result = isValidSerialization(preorder);
        System.out.println(result);
    }

    public static boolean isValidSerialization(String preorder) {
        int indegree = 1;
        for (String s : preorder.split(",")) {
            if (--indegree < 0) return false;
            if (!s.equals("#")) indegree += 2;
        }
        return indegree == 0;
    }
}
