package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    * Time: O(1)
    * Space: O(capacity), for hashmap and linkedlist
    * The HashMap and DLinkedList work independently of each other, although they hold kind of the same data.
    *
    * We use the has map to hold a pointer to the place where the data with a given key is stored. This reference
    * can be used to use the DLinkNode.
    *
    * For example, if we want to get the element with key 5, we first use the HashMap to get a pointer to the
    * memory location of where the data with key 5 is stored. With this reference we can then get node.value and
    * move it to the head of the DLinkNode
    *
    * Add a node to a DLinkNode:
    * We only modify the pointers inside head and node, we don't reallocate the pointers towards head or tail.
    * Think of the list as going head <=> tail, all nodes will be inserted before the head.
    *
    * In the first step, we focus on allocating the new node's pointers:
    * node.prev = head
    * node.next = head.next (we cannot link the node.next to tail, as there might be nodes between)
    *
    * Then we need to reallocate the connections between head and it's previous element, towards the new node:
    * head.next.prev = node (head.next is head's previous element, so we change it's prev pointer towards the new node)
    * head.next = node
    *
    * */


    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head, tail;

    private void addNode(DLinkNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkNode node) {
            DLinkNode prev = node.prev;
            DLinkNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkNode popTail() {
            DLinkNode temp = tail.prev;
            removeNode(temp);
            return temp;
        }

    // head - nodes - tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);

        if (node == null) {
            DLinkNode newNode = new DLinkNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            size++;

            if (size > capacity) {
                DLinkNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
