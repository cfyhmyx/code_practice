//Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
//You must do this in-place without altering the nodes' values.
//For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.

public class Leetcode143 {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
     //   n4.next = n5;

        reorderList(n1);
        while(n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void reorderList(ListNode head) {
        if(head == null) return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode preslow = null;
        while(fast != null && fast.next!=null) {
            preslow = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast!=null) {
            preslow = slow;
            slow = slow.next;
        }
        preslow.next = null;
        slow = reverse(slow);
        fast = head;
        ListNode slowNext = null;
        ListNode fastNext = null;
        while(slow != null) {
            slowNext = slow.next;
            fastNext = fast.next;
            fast.next = slow;
            slow.next = fastNext;
            fast = fastNext;
            slow = slowNext;
        }
    }

    private static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode next = null;
        while(node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
