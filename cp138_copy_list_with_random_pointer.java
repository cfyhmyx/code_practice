//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//Return a deep copy of the list.

import java.util.*;

public class Leetcode138 {
    public static void main(String args[]) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        Queue<RandomListNode> queue = new LinkedList<>();
        map.put(head, new RandomListNode(head.label));
        queue.add(head);
        while(!queue.isEmpty()) {
            RandomListNode cur = queue.poll();
            if(cur.next != null) {
                if(!map.containsKey(cur.next)) {
                    RandomListNode next = new RandomListNode(cur.next.label);
                    map.put(cur.next, next);
                    queue.add(cur.next);
                }
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null) {
                if(!map.containsKey(cur.random)) {
                    RandomListNode random = new RandomListNode(cur.random.label);
                    map.put(cur.random, random);
                    queue.add(cur.random);
                }
                map.get(cur).random = map.get(cur.random);
            }
        }
        return map.get(head);
    }

    //easier way
    /*public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode,RandomListNode> Visited= new HashMap<>();
        RandomListNode node = head;
        while(node != null){
            Visited.put(node,new RandomListNode(node.label));
            node = node.next;
        }
        node = head;
        while(node !=null){
            Visited.get(node).next = Visited.get(node.next);
            if(node.random !=null){
                Visited.get(node).random = Visited.get(node.random);
            }
            node =node.next;
        }
        return Visited.get(head);
    }*/

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

}
