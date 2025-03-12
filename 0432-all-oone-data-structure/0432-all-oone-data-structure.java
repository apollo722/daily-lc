class AllOne {
    int cnt = 0;
    class DNode {
        HashSet<String> set = new HashSet<>();
        int freq = 0;
        DNode prev, next;
        DNode() {
            freq = -1;
        }
        public void add(String key) {
            this.set.add(key);
        }
        public void remove(String key) {
            this.set.remove(key);
        }
    }

    DNode head, tail;
    HashMap<String, DNode> m = new HashMap<>();
    public DNode addNode(DNode cur, int freq) {
        DNode next = cur.next;
        DNode newNode = new DNode();
        newNode.freq = freq;
        cur.next = newNode;
        newNode.prev = cur;
        next.prev = newNode;
        newNode.next = next;
        return newNode;
    }

    public void removeNode(DNode cur) {
        DNode prev = cur.prev;
        DNode next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    public AllOne() {
        head = new DNode();
        tail = new DNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        DNode cur = m.getOrDefault(key, null);
        if (cur == null) {
            if (head.next.freq == 1) {
                head.next.add(key);
                m.put(key, head.next);
            } else {
                DNode newNode = addNode(head, 1);
                newNode.add(key);
                m.put(key, newNode);
            }
            
        } else {
            int curFreq = cur.freq;
            if (cur.next.freq == curFreq + 1) {
                cur.next.add(key);
                cur.remove(key);
                if (cur.set.size() == 0) removeNode(cur);
                m.put(key, cur.next);
            } else {
                DNode newNode = addNode(cur, curFreq + 1);
                newNode.add(key);
                cur.remove(key);
                if (cur.set.size() == 0) removeNode(cur);
                m.put(key, newNode);
            }
        }
    }
    
    public void dec(String key) {
        DNode cur = m.get(key);
        int curFreq = cur.freq;
        if (curFreq == 1) {
            cur.remove(key);
            if (cur.set.size() == 0) removeNode(cur);
            m.remove(key);
            return ;
        }
        if (cur.prev.freq == curFreq - 1) {
            cur.prev.add(key);
            cur.remove(key);
            if (cur.set.size() == 0) removeNode(cur);
            m.put(key, cur.prev);
        } else {
            DNode newNode = addNode(cur.prev, curFreq - 1);
            newNode.add(key);
            cur.remove(key);
            if (cur.set.size() == 0) removeNode(cur);
            m.put(key, newNode);
        }
    }
    
    public String getMaxKey() {
        if (tail.prev == head) return "";
        return tail.prev.set.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next == tail) return "";
        return head.next.set.iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */