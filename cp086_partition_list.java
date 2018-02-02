//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

public class Leetcode086 {
    public static void main(String args[]) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode head = partition(n1, 2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode smallDummy = new ListNode(0);
        ListNode smallIndex = smallDummy;
        ListNode bigDummy = new ListNode(0);
        ListNode bigIndex = bigDummy;
        while(head != null) {
            if(head.val < x){
                smallIndex.next = head;
                smallIndex = smallIndex.next;
            } else {
                bigIndex.next = head;
                bigIndex = bigIndex.next;
            }
            head = head.next;
        }
        bigIndex.next = null;
        smallIndex.next = bigDummy.next;
        return smallDummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
