//Reverse a singly linked list.

public class Leetcode206 {
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
        ListNode head = reverseList(l0);
        while(head != null) {
            System.out.print(head.val);
            System.out.print(" ");
            head = head.next;
        }
    }

    //iteration
    public static ListNode reverseList(ListNode head) {
        ListNode first = null;
        ListNode second = head;
        while(first!=null || second!=null) {
            if(second == null) return first;
            ListNode temp = second.next;
            second.next = first;
            first = second;
            second = temp;
        }
        return first;
    }

    //recursion
    /*public static ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    public static ListNode reverse(ListNode first, ListNode second) {
        if(second == null) return first;
        ListNode temp = second.next;
        second.next = first;
        return reverse(second, temp);
    }*/

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
