class AllOne {
    class DNode {
        DNode prev, next;
        int cnt;
        Set<String> keys = new HashSet<>();
        public DNode(int cnt) {
            this.cnt = cnt;
        }
    }

    public DNode addNext(DNode cur, int cnt) {
        DNode next = cur.next;
        DNode res = new DNode(cnt);
        cur.next = res;
        res.prev = cur;
        res.next = next;
        next.prev = res;
        return res;
    }

    public void remove(DNode cur) {
        DNode prev = cur.prev, next = cur.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeKey(DNode cur, String key) {
        if (cur.keys.contains(key)) {
            cur.keys.remove(key);
        }
        if (cur.keys.size() == 0) {
            remove(cur);
        }
    }

    DNode head, tail;
    Map<String, DNode> m = new HashMap<>();

    public AllOne() {
        head = new DNode(-1);
        tail = new DNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void inc(String key) {
        if (m.containsKey(key)) {
            DNode cur = m.get(key);
            int curCnt = cur.cnt;
            if (cur.next.cnt == curCnt + 1) {
                cur.next.keys.add(key);
                m.put(key, cur.next);
            } else {
                DNode res = addNext(cur, curCnt + 1);
                res.keys.add(key);
                m.put(key, res);
            }
            removeKey(cur, key);
        } else {
            if (head.next.cnt == 1) {
                m.put(key, head.next);
                head.next.keys.add(key);
            } else {
                DNode res = addNext(head, 1);
                res.keys.add(key);
                m.put(key,res);
            }
        }
    }
    
    public void dec(String key) {
        DNode cur = m.get(key);
        int curCnt = cur.cnt;
        if (curCnt == 1) {
            ;
        }
        else if (cur.prev.cnt == curCnt - 1) {
            cur.prev.keys.add(key);
            m.put(key, cur.prev);
        } else {
            DNode res = addNext(cur.prev, curCnt - 1);
            res.keys.add(key);
            m.put(key, res);
        }
        removeKey(cur, key);
        if (curCnt == 1) m.remove(key);
    }
    
    public String getMaxKey() {
        if (tail.prev.cnt == -1) return "";
        return tail.prev.keys.iterator().next();
    }
    
    public String getMinKey() {
        if (head.next.cnt == -1) return "";
        return head.next.keys.iterator().next();
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
