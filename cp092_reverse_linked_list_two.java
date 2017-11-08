public class Leetcode092 {
    public static void main(String args[]) {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l0.next=l1;
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        l4.next=l5;
        ListNode head = reverseBetween(l0,2,4);
        while(head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        ListNode cur = dummy;
        ListNode pre = null;
        while(count<m) {
            pre= cur;
            cur = cur.next;
            count++;
        }
        ListNode next = cur.next;
        while(count<n) {
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
            count++;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
