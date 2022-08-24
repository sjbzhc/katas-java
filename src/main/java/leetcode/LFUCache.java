package leetcode;

import java.util.HashMap;

/*
* For each frequency, we maintain a LinkedList. This enables O(1) add and remove
* To access a Node in O(1) time, we have a HashMap
*
* minFrequency is increased whenever we increase the freq of a node whose freq is the same
* as minFrequency and whose LinkedList is empty
*
* minFrequency is reset to 0 when one element is evicted from the cache
* */

class LFUCache {

    private class Node{
        int key;
        int value;
        int frequency;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private class NodeDLinkedList {

        Node head, tail;
        int length;

        public NodeDLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

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

        //Remove a node
        void remove(Node node) {

            if (node == head) {
                if (node == tail) tail = null;
                head = head.next;
            } else {
                node.prev.next = node.next;
                if (node == tail) tail = node.prev;
                else node.next.prev = node.prev;
            }

        }

        Node removeLastNode(){

            Node tailNode = tail;

            if(tailNode != null) {
                remove(tailNode);
            }
            return tailNode;
        }
    }

    int capacity;
    HashMap<Integer, Node> cache = new HashMap<>();
    HashMap<Integer, NodeDLinkedList> freqToList = new HashMap<>();
    int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node != null) {
            incrementFrequency(node);
            return node.value;
        }
        else{
            return -1;
        }
    }

    public void put(int key, int value) {

        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            incrementFrequency(node);
        } else {
            Node node = new Node(key, value);

            if (cache.size() == capacity) {
                Node removedLastNode = freqToList.get(minFreq).removeLastNode();
                cache.remove(removedLastNode.key);
            }

            incrementFrequency(node);
            cache.put(key, node);

            minFreq = 1;
        }

    }


    private void incrementFrequency(Node node){

        int oldFrequency = node.frequency;

        if (freqToList.containsKey(oldFrequency)) {
            NodeDLinkedList oldNodeDLinkedList = freqToList.get(oldFrequency);
            oldNodeDLinkedList.remove(node);
            if (node.frequency == minFreq && oldNodeDLinkedList.length == 0) {
                minFreq++;
            }
        }

        int newFrequency = oldFrequency + 1;
        node.frequency = newFrequency;
        NodeDLinkedList newNodeDLinkedList = freqToList.getOrDefault(newFrequency, new NodeDLinkedList());
        newNodeDLinkedList.add(node);
        freqToList.put(newFrequency, newNodeDLinkedList);
    }
}
