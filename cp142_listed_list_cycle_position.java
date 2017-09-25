//Given a linked list, return the node where the cycle begins. If there is no cycle, return null
public class Leetcode142 {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        ListNode result = detectCycle(n1);
        System.out.println(result.val);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //move k step, slow and fast meet, 2k-k = r, r is the length of circle.
    //s: the distance between start node and the start node of circle.
    //m: the distance between the start node of cycle and the meet point.
    //s = k-m = r-m
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle) return null;
        slow = head;
        while( slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
