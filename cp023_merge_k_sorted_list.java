//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
//we also could use heap to solve this problem
//complexity: k: lists length, n: average list length, kn*longk.
//https://discuss.leetcode.com/topic/6882/sharing-my-straightforward-c-solution-without-data-structure-other-than-vector/25
//(2n)*(k/2)+(4n)*(k/4)+(8n)*(k/8)+...+(2^logk *n)*(k/(2^logk)) = kn*logk
public class Leetcode023 {
    public static void main(String args[]) {
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int low = 0;
        int high = lists.length-1;
        return merge(low, high, lists);
    }

    private static ListNode merge(int low, int high, ListNode[] lists) {
        if(high < low) return null;
        if(high == low) return lists[low];
        int mid = low+(high-low)/2;
        ListNode left = merge(low, mid, lists);
        ListNode right = merge(mid+1, high, lists);
        return mergeTwo(left, right);
    }

    private static ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        while(left != null && right != null) {
            int v1 = left.val;
            int v2 = right.val;
            if(v1 <= v2) {
                index.next = left;
                left = left.next;
            } else {
                index.next = right;
                right = right.next;
            }
            index = index.next;
        }
        if(left != null) {
            index.next = left;
        } else {
            index.next = right;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
