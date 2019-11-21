import java.util.HashMap;
import java.util.Map;

public class FlattenList {
    public Node flatten(Node head) {
        Map<Integer,Node> levels = new HashMap<>();
        Integer max = traverse(head,levels,0)-1;
        for(int i = 0; i<=max; i++ )  {
            if (i == 0) {
                levels.get(0).prev = null;
                levels.get(0).next = levels.get(1);
            }
            if (i == max && max != 0) {
                levels.get(max).next = null;
                levels.get(max).prev = levels.get(max-1);
            }
            else {
                levels.get(i).prev = levels.get(i-1);
                levels.get(i).next = levels.get(i+1);
            }
            levels.get(i).child = null;
        }
        return head;
    }

    public Integer traverse(Node n, Map<Integer,Node> levels, Integer level) {

        if (n == null) {
            return level;
        }
        Integer currentLevel = level+1;
        levels.put(level,n);
        currentLevel = traverse(n.child,levels,currentLevel);
        currentLevel = traverse(n.next,levels,currentLevel);

        return currentLevel;
    }




    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node() {}
    }
}
