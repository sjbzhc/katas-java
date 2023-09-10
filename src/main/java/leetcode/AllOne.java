package leetcode;

import java.util.*;

/*
* https://leetcode.com/problems/all-oone-data-structure/
* Time: O(1)
* Space: O(n)
* */

public class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev;
        Node next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Map<String, Node> keyMap;
    private Node min; // Represents the minimum count
    private Node max; // Represents the maximum count

    public AllOne() {
        keyMap = new HashMap<>();
        min = new Node(Integer.MIN_VALUE);
        max = new Node(Integer.MAX_VALUE);
        min.next = max;
        max.prev = min;
    }

    public void inc(String key) {
        if (keyMap.containsKey(key)) {
            Node current = keyMap.get(key);
            current.keys.remove(key);
            Node nextNode = current.next;

            if (nextNode != max && nextNode.count == current.count + 1) {
                nextNode.keys.add(key);
                keyMap.put(key, nextNode);
            } else {
                Node newNode = new Node(current.count + 1);
                newNode.keys.add(key);
                insertAfter(newNode, current);
                keyMap.put(key, newNode);
            }

            if (current.keys.isEmpty()) {
                remove(current);
            }
        } else {
            // Start from 1, using existing or creating new
            if (min.next.count == 1) {
                min.next.keys.add(key);
                keyMap.put(key, min.next);
            } else {
                Node newNode = new Node(1);
                newNode.keys.add(key);
                insertAfter(newNode, min);
                keyMap.put(key, newNode);
            }
        }
    }

    public void dec(String key) {
        if (keyMap.containsKey(key)) {
            Node current = keyMap.get(key);
            current.keys.remove(key);

            if (current.count > 1) {
                Node prevNode = current.prev;

                if (prevNode.count == current.count - 1) {
                    prevNode.keys.add(key);
                    keyMap.put(key, prevNode);
                } else {
                    // This means prevNode.count is at least current.count -2
                    Node newNode = new Node(current.count - 1);
                    newNode.keys.add(key);
                    insertAfter(newNode, prevNode);
                    keyMap.put(key, newNode);
                }
            } else {
                // current count <= 1, therefore remove reference to this key as it won't be in any node after decrease
                keyMap.remove(key);
            }

            if (current.keys.isEmpty()) {
                remove(current);
            }
        }
    }

    public String getMaxKey() {
        if (max.prev != min) {
            return max.prev.keys.iterator().next();
        } else {
            return "";
        }
    }

    public String getMinKey() {
        if (min.next != max) {
            return min.next.keys.iterator().next();
        } else {
            return "";
        }
    }

    // Helper method to insert a new node after a given node
    private void insertAfter(Node newNode, Node node) {
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
    }

    // Helper method to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}


// Log n
//public class AllOne {
//    private final Map<String, Integer> stringFreq;
//    private final TreeMap<Integer, Set<String>> countToStrings;
//    public AllOne() {
//        stringFreq = new HashMap<>();
//        countToStrings = new TreeMap<>();
//    }
//
//    public void inc(String key) {
//        int oldCount = stringFreq.getOrDefault(key, 0);
//        int newCount = oldCount + 1;
//        stringFreq.put(key, newCount);
//
//        removeFromOldBucket(oldCount, key);
//        addToNewBucket(newCount, key);
//    }
//
//    public void dec(String key) {
//        int oldCount = stringFreq.getOrDefault(key, 0);
//        int newCount = oldCount - 1;
//        stringFreq.put(key, newCount);
//
//        if (newCount == 0) {
//            stringFreq.remove(key);
//        }
//
//        removeFromOldBucket(oldCount, key);
//        addToNewBucket(newCount, key);
//    }
//
//    private void removeFromOldBucket(int bucketKey, String key) {
//        if (bucketKey > 0) {
//            Set<String> strings = countToStrings.get(bucketKey);
//            if (strings.size() == 1) {
//                strings.clear();
//                countToStrings.remove(bucketKey);
//            } else {
//                strings.remove(key);
//            }
//        }
//    }
//
//    private void addToNewBucket(int bucketKey, String key) {
//        if (bucketKey > 0) {
//            countToStrings.putIfAbsent(bucketKey, new HashSet<>());
//            countToStrings.get(bucketKey).add(key);
//        }
//    }
//
//    public String getMaxKey() {
//        return countToStrings.isEmpty() ? "" : countToStrings.lastEntry().getValue().iterator().next();
//    }
//
//    public String getMinKey() {
//        return countToStrings.isEmpty() ? "" : countToStrings.firstEntry().getValue().iterator().next();
//    }
//}
