//Sort a linked list using insertion sort.

public class Leetcode147 {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        ListNode result = insertionSortList(n1);

        while(n1 != null) {
            System.out.println(n1.val);
            n1 = n1.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            while(pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }

    public  static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
