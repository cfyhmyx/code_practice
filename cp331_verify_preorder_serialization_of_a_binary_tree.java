//description: https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
import java.util.Stack;

public class Leetcode331 {
    public static void main(String args[]) {
        String preorder = "9,#,92,#,#";
        boolean result = isValidSerialization(preorder);
        System.out.println(result);
    }

    public static boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.isEmpty()) return false;
        if(preorder.equals("#")) return true;
        String[] node = preorder.split(",");
        if(node.length == 0 || node[0].equals("#")) return false;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        s1.push(Integer.parseInt(node[0]));
        s2.push(0);
        for(int i=1; i<node.length; i++) {
            while(!s2.isEmpty() && s2.peek() == 2) {
                s1.pop();
                s2.pop();
            }
            if(s1.isEmpty()) return false;
            if(!node[i].equals("#")) {
                s1.push(Integer.parseInt(node[i]));
            }
            if(!s2.isEmpty()) {
                int temp = s2.pop();
                s2.push(temp+1);
            }
            if(!node[i].equals("#")) {
                s2.push(0);
            }
        }
        while(!s2.isEmpty() && s2.peek() == 2) {
            s1.pop();
            s2.pop();
        }
        return s1.isEmpty();
    }

    /*        if (preorder == null) {
            return false;
        }
        Stack<String> st = new Stack<>();
        String[] strs = preorder.split(",");
        for (int pos = 0; pos < strs.length; pos++) {
            String curr = strs[pos];
            while (curr.equals("#") && !st.isEmpty() && st.peek().equals(curr)) {
                st.pop();
                if (st.isEmpty()) {
                    return false;
                }
                st.pop();
            }
            st.push(curr);
        }
        return st.size() == 1 && st.peek().equals("#");*/

    //better way
    /*    public boolean isValidSerialization(String preorder) {
        int diff = 1;
        for (String s : preorder.split(",")) {
            if (--diff < 0) return false;
            if (!s.equals("#")) diff += 2;
        }
        return diff == 0;
    }*/

}
