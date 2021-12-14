package chapter02;

public class DeleteMiddleNode {

    public void deleteMiddleNode(LinkedListNode node) {
        if (node.next != null) {
            node.data = node.next.data;
            node.next = node.next.next;
        } else {
            node = null;
        }
    }
}
