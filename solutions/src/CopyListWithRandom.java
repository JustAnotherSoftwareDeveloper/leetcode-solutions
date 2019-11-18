import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandom {

    public Node copyRandomList(Node head) {
        Map<Integer,Node> valueToNodes = new HashMap<>();
        Node currentNode = head;
        while (currentNode != null) {
            Node newNode = new Node(currentNode.val,null,null);
            valueToNodes.put(currentNode.val,newNode);
            currentNode = currentNode.next;
        }
        currentNode = head;
        while (currentNode != null) {
            Node correspondingNode = valueToNodes.get(currentNode.val);
            if (currentNode.next != null) {
                correspondingNode.next = valueToNodes.get(currentNode.next.val);
            }
            if (currentNode.random != null) {
                correspondingNode.random = valueToNodes.get(currentNode.random.val);
            }
            currentNode = currentNode.next;
        }
        return head == null ? null : valueToNodes.get(head.val);
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}
