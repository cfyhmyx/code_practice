//Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
//You may assume the integer do not contain any leading zero, except the number 0 itself.
//The digits are stored such that the most significant digit is at the head of the list.

public class Leetcode369 {
    public static void main(String args[]) {
        ListNode node1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode result = plusOne(node1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode plusOne(ListNode head) {
        if(head == null) return null;
        ListNode newHead = reverseList(head);
        ListNode node = newHead;
        ListNode pre = null;
        while(node != null) {
            if(node.val <9) {
                node.val++;
                return reverseList(newHead);
            }
            node.val=0;
            pre = node;
            node=node.next;
        }
        pre.next = new ListNode(1);
        return reverseList(newHead);
    }

    private static ListNode reverseList(ListNode node) {
        ListNode cur = node;
        ListNode pre = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //no reverse method
    /*(public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit

        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }

        if (dummy.val == 0) return dummy.next;
        return dummy;
    }*/

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
