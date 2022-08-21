package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* For each frequency, we maintain a LinkedList. This enables O(1) add and remove
* To access a Node in O(1) time, we have a HashMap
*
* minFrequency is increased whenever we increase the freq of a node whose freq is the same
* as minFrequency and whose LinkedList is empty
*
* minFrequency is reset to 0 when one element is evicted from the cache
* */

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
            frequency = 1;
        }
    }

    class NodeLinkedList {
        Node head;
        Node tail;
        int length;

        public NodeLinkedList() {
            this.head = new Node(0, 0);
            this.tail =  new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next = node;
            head.next.prev = node;
            length++;
        }

        void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
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
    Map<Integer, Node> cache;
    Map<Integer, NodeLinkedList> freqToLinkedList;
    int minimumFrequency = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqToLinkedList = new HashMap<>();
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node != null) {
            incrementFrequency(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            incrementFrequency(node);
            cache.put(key, node);
        } else {
            Node node = new Node(key, value);

            if (cache.size() == capacity) {
                Node removedLastNode = freqToLinkedList.get(minimumFrequency).removeLastNode();
                cache.remove(removedLastNode.key);
            }

            incrementFrequency(node);
            cache.put(key, node);
            minimumFrequency = 1;
        }
    }

    private void incrementFrequency(Node node) {
        int currentFreq = node.frequency;

        if (freqToLinkedList.containsKey(currentFreq)) {
            NodeLinkedList currentList = freqToLinkedList.get(currentFreq);
            currentList.remove(node);
            // Min freq is updated if currFreq is the min and the list is empty.
            // Otherwise, another list could exist with the minFreq value
            if (currentFreq == minimumFrequency && currentList.length == 0) {
                minimumFrequency++;
            }
        }

        int newFrequency = currentFreq + 1;
        node.frequency = newFrequency;
        NodeLinkedList newList = freqToLinkedList.getOrDefault(newFrequency, new NodeLinkedList());
        newList.add(node);
        freqToLinkedList.put(newFrequency, newList);
    }
}
