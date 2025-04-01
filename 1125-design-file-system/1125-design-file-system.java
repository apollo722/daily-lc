class FileSystem {

    class Node {
        int val;
        HashMap<String, Node> next;
        Node() {
            next = new HashMap<>();
        }
    }
    Node root; 

    public FileSystem() {
        root = new Node();
    }
    
    public boolean createPath(String path, int value) {
        Node cur = root;
        String[] items = path.split("/");
        for (int i = 1; i < items.length; i++) {
            String item = items[i];
            if (!cur.next.containsKey(item)) {
                if (i != items.length - 1) return false;
                cur.next.put(item, new Node());
            } else {
                if (i == items.length - 1) return false;
            }
            cur = cur.next.get(item);
        }
        cur.val = value;
        return true;
    }
    
    public int get(String path) {
        Node cur = root;
        String[] items = path.split("/");
        for (int i = 1; i < items.length; i++) {
            String item = items[i];
            if (!cur.next.containsKey(item)) return -1;
            cur = cur.next.get(item);
        }
        return cur.val;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */