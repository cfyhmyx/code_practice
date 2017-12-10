//Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

import java.util.*;

public class Leetcode133 {
    public static void main(String args[]) {
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        node.neighbors.add(new UndirectedGraphNode(node.label));
        node.neighbors.add(new UndirectedGraphNode(node.label));
        UndirectedGraphNode result = cloneGraph(node);
        System.out.println(result.label);
    }

    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        Map<UndirectedGraphNode, UndirectedGraphNode> myMap = new HashMap<>();
        Queue<UndirectedGraphNode> myQueue = new LinkedList<>();
        myQueue.add(node);
        myMap.put(node, new UndirectedGraphNode(node.label));
        while(!myQueue.isEmpty()) {
            UndirectedGraphNode cur = myQueue.poll();
            for(int i=0; i<cur.neighbors.size(); i++) {
                if(!myMap.containsKey(cur.neighbors.get(i))) {
                    UndirectedGraphNode clone = new UndirectedGraphNode(cur.neighbors.get(i).label);
                    myMap.put(cur.neighbors.get(i), clone);
                    myQueue.add(cur.neighbors.get(i));
                }
                myMap.get(cur).neighbors.add(myMap.get(cur.neighbors.get(i)));
            }
        }
        return myMap.get(node);
    }

    //dfs
    /*private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;

        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }*/

    static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<>(); }
    }
}
