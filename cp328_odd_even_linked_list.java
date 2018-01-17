//Given a singly linked list, group all odd nodes together followed by the even nodes.
//Please note here we are talking about the node number and not the value in the nodes.
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

public class Leetcode328 {
    public static void main(String args[]) {

    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode oddHead = head;
        ListNode evenHead = head.next;
        ListNode odd = oddHead;
        ListNode even = evenHead;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            if(odd != null) {
                even.next = odd.next;
                even = even.next;
            }
        }
        odd.next = evenHead;
        return oddHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
