package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;
    }

    public void removeNode(DLinkNode node) {
        DLinkNode prev = node.prev;
        DLinkNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public DLinkNode popTail() {
        DLinkNode temp = tail.prev;
        removeNode(temp);
        return temp;
    }

    private int capacity;
    private int size;
    private Map<Integer, DLinkNode> map = new HashMap<>();
    DLinkNode head = new DLinkNode();
    DLinkNode tail = new DLinkNode();

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value) {
        DLinkNode node = map.get(key);
        if (node == null) {
            DLinkNode n = new DLinkNode();
            n.key = key;
            n.value = value;
            add(n);
            map.put(key, n);
            size++;
        } else {
            node.value = value;
            moveToHead(node);
        }
        if (size > capacity) {
            evictOldest();
        }
    }

    private void add(DLinkNode n) {
        n.prev = head;
        n.next = head.next;

        head.next.prev = n;
        head.next = n;
    }

    private void evictOldest() {
        DLinkNode tail = popTail();
        map.remove(tail.key);
        size--;
    }

    public int get(int key) {
        DLinkNode node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        add(node);
    }
}
