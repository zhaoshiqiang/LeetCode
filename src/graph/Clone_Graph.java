package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 133题：Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


     OJ's undirected graph serialization:
     Nodes are labeled uniquely.

     We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
     As an example, consider the serialized graph {0,1,2#1,2#2,2}.

     The graph has a total of three nodes, and therefore contains three parts as separated by #.

     First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
     Second node is labeled as 1. Connect node 1 to node 2.
     Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
     Visually, the graph looks like the following:

         1
        / \
       /   \
      0 --- 2
           / \
           \_/
 * Created by zhaoshiqiang on 2016/12/28.
 */
//算法：DFS or BFS，数据结构：哈希表
public class Clone_Graph {
    private Map<Integer,UndirectedGraphNode> nodemap = new HashMap<Integer, UndirectedGraphNode>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null){
            return null;
        }
        //如果已经在map中，则直接返回
        if (nodemap.containsKey(node.label)){
            return nodemap.get(node.label);
        }
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        nodemap.put(newnode.label,newnode);
        for (UndirectedGraphNode temp : node.neighbors){
            newnode.neighbors.add(cloneGraph(temp));
        }
        return newnode;
    }

    class UndirectedGraphNode{
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }
}

