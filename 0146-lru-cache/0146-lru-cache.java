class LRUCache {
    class DNode {
        int key, val;
        DNode next, prev;
        DNode () {  }
        DNode (int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    DNode head, tail;
    HashMap<Integer, DNode> m = new HashMap<>();
    int capacity, size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }

    public void addToTail(DNode node) {
        DNode prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(DNode node) {
        DNode prev = node.prev, next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void moveToTail(DNode node) {
        remove(node);
        addToTail(node);
    }
    
    public int get(int key) {
        DNode node = m.get(key);
        if (node == null) return -1;
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (m.containsKey(key)) {
            DNode node = m.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            DNode node = new DNode(key, value);
            addToTail(node);
            m.put(key, node);
            size++;
            if (size > capacity) {
                m.remove(head.next.key);
                remove(head.next);
                size--;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */