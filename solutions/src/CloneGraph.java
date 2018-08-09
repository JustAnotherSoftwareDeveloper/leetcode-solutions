import java.util.*;
import java.util.stream.Collectors;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
public class CloneGraph {
//https://leetcode.com/problems/clone-graph/description/
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        return cloneHelper(node, new HashMap<>());
    }

    private UndirectedGraphNode cloneHelper(UndirectedGraphNode node, HashMap<Integer,UndirectedGraphNode> idToVisitedNode) {
        if (idToVisitedNode.containsKey(node.label)) {
            return idToVisitedNode.get(node.label);
        }
        UndirectedGraphNode copyOf = new UndirectedGraphNode(node.label);
        idToVisitedNode.put(copyOf.label,copyOf);
        copyOf.neighbors = node.neighbors.stream().map(n -> cloneHelper(n,idToVisitedNode)).collect(Collectors.toList());
        return copyOf;

    }
}