//Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
//What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?

import java.util.Random;

public class Leetcode382 {
    public static void main(String args[]) {
    }

    //reservoir sampling
    class Solution {

        ListNode head;
        Random random;
        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int total = 0;
            int result = 0;
            ListNode temp = head;
            while(temp != null) {
                if(random.nextInt(++total) == 0){
                    result = temp.val;
                }
                temp = temp.next;
            }
            return result;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
