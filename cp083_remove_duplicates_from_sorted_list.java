//Given a sorted linked list, delete all duplicates such that each element appear only once.

public class Leetcode082 {
    public static void main(String args[]) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == pre.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
