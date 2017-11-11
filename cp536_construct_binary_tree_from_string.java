//You need to construct a binary tree from a string consisting of parenthesis and integers.
//The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis.
//The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
//You always start to construct the left child node of the parent first if it exists.

public class Leetcode536 {
    public static void main(String args[]) {
        TreeNode result = str2tree("-4(2(3)(1))(6(5))");
        System.out.println(result.val);
    }

    public static TreeNode str2tree(String s) {
        if(s==null || s.equals("")) return null;
        int i=0;
        for(; i<s.length();){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'||s.charAt(i)=='-') i++;
            else break;
        }
        TreeNode node = new TreeNode(Integer.valueOf(s.substring(0,i)));
        int open = 1;
        int start = ++i;
        for(;i<s.length();i++) {
            if(s.charAt(i) == '(') open++;
            else if(s.charAt(i) == ')') open--;
            if(open == 0) break;
        }
        node.left = str2tree(i>start ? s.substring(start,i) : null);
        node.right = str2tree(s.length()-1>i+2 ? s.substring(i+2, s.length()-1) : null);
        return node;
    }

    public  static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
