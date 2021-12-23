package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        public Node prev;
        public Node next;
        public int key;
        public int value;
        public int frequency;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class NodeLinkedList {
        Node head;
        Node tail;
        int length;

        void add(Node node) {
            node.prev = null;
            node.next = null;

            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
                head = node;
            }

            length++;
        }

        void remove(Node node) {
            if (node == head) {
                if (node == tail) {
                    tail = null;
                }
                head = head.next;
            } else {
                if (node == tail) {
                    tail = node.prev;
                } else {
                    node.next.prev = node.prev;
                }
            }
            length--;
        }

        Node removeLastNode() {
            Node tailNode = tail;

            if (tailNode != null) {
                remove(tailNode);
            }
            return tailNode;
        }
    }

    int capacity;
    Map<Integer, Node> keyToNode;
    Map<Integer, NodeLinkedList> frequencyToNodeLinkedList;
    int minimumFrequency = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToNode = new HashMap<>();
        frequencyToNodeLinkedList = new HashMap<>();
    }

    public int get(int key) {
        Node node = keyToNode.get(key);
        if (node != null) {
            incrementFrequency(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if (capacity <= 0) {
            return;
        }

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            incrementFrequency(node);
            keyToNode.put(key, node);
        } else {
            Node node = new Node(key, value);

            if (keyToNode.size() == capacity) {
                Node removedLastNode = frequencyToNodeLinkedList.get(minimumFrequency).removeLastNode();
                keyToNode.remove(removedLastNode.key);
            }
            incrementFrequency(node);
            keyToNode.put(key, node);

            minimumFrequency = 1;
        }
    }

    private void incrementFrequency(Node node) {
        int oldFrequency = node.frequency;

        if (frequencyToNodeLinkedList.containsKey(oldFrequency)) {
            NodeLinkedList oldNodeLinkedList = frequencyToNodeLinkedList.get(oldFrequency);
            oldNodeLinkedList.remove(node);
            if (oldFrequency == minimumFrequency && oldNodeLinkedList.length == 0) {
                minimumFrequency++;
            }
        }

        int newFrequency = oldFrequency + 1;
        node.frequency = newFrequency;
        NodeLinkedList newNode = frequencyToNodeLinkedList.getOrDefault(newFrequency, new NodeLinkedList());
        newNode.add(node);
        frequencyToNodeLinkedList.put(newFrequency, newNode);

    }
}
