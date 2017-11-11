//You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
//The null node needs to be represented by empty parenthesis pair "()".
//And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

public class Leetcode606 {
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;
        String result = tree2str(n1);
        System.out.println(result);
    }

    public static String tree2str(TreeNode t) {
        if(t == null) return "";
        StringBuilder resultBuilder = new StringBuilder();
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        resultBuilder.append(t.val);
        if(!left.equals("") || !right.equals("")){
            resultBuilder.append('(').append(left).append(')');
        }
        if(!right.equals("")) {
            resultBuilder.append('(').append(right).append(')');
        }
        return resultBuilder.toString();
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
