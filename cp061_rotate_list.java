//Given a list, rotate the list to the right by k places, where k is non-negative.

public class Leetcode061 {
    public static void main(String args[]) {

    }

    public ListNode rotateRight(ListNode head, int k ) {
        if(head == null || head.next == null) return head;
        ListNode index = head;
        int len = 1;
        while(index.next != null) {
            index = index.next;
            len++;
        }
        index.next = head;
        for(int i=1; i<len-k%len; i++) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

    /*public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null) return head;
        int length = 0;
        ListNode node = head;
        while(node!=null) {
            length++;
            node = node.next;
        }
        k = k%length;
        if(k==0) return head;
        ListNode fast = head;
        int count=0;
        while(count<k) {
            fast = fast.next;
            count++;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }*/

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
