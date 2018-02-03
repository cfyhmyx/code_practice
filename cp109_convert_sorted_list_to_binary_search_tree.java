//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees
//of every node never differ by more than 1.

public class Leetcode109 {
    public static void main(String args[]) {
        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        TreeNode node = sortedListToBST(node1);
        System.out.println(node.val);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return helper(head, null);
    }

    private static TreeNode helper(ListNode head, ListNode tail) {
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
