/*
https://leetcode.com/problems/lru-cache/

double linked list，注意DNode里面要同时存储key value，以便remove node的时候可以直到从map中移除哪个key

Time: O(1)
Space: O(capacity)
*/

class LRUCache {
    class DNode {
        int val, key;
        DNode prev;
        DNode next;
        DNode() {  }
        DNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DNode head, tail;
    int size, capacity;
    Map<Integer, DNode> m;

    public LRUCache(int capacity) {
        this.m = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        this.head = new DNode();
        this.tail = new DNode();
        head.next = tail;
        tail.prev = head;    
    }

    private void remove(DNode node) {
        DNode next = node.next, prev = node.prev;
        prev.next = next;
        next.prev = prev;
    }

    private void addToTail(DNode node) {
        DNode prev = this.tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void moveToTail(DNode node) {
        remove(node);
        addToTail(node);
    }
    
    public int get(int key) {
        if (m.containsKey(key)) {
            DNode node = m.get(key);
            moveToTail(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        DNode node = m.get(key);
        if (node == null) {
            node = new DNode(key, value);
            m.put(key, node);
            addToTail(node);
            size++;
            if (size > capacity) {
                m.remove(this.head.next.key);
                remove(this.head.next);
                size--;
            }
        } else {
            moveToTail(node);
            node.val = value;
        }
    }
}