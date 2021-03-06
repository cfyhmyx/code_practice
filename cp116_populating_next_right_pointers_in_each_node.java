//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/

public class Leetcode116 {
    public static void main(String args[]) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(5);
        TreeLinkNode n4 = new TreeLinkNode(3);
        TreeLinkNode n5 = new TreeLinkNode(4);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(32);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        connect(n1);
    }

    public static void connect(TreeLinkNode root) {
        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
    }

    /*public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        if(root != null) {
            q.add(root);
        }
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i=0; i<len; i++) {
                TreeLinkNode temp = q.poll();
                if(i<len-1) {
                    temp.next = q.peek();
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
        }
        return;
    }*/


    public static class TreeLinkNode {
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        TreeLinkNode(int x) { val = x; }
    }
}
