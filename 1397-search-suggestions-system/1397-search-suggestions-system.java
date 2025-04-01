class Solution {
    class Node {
        Node[] next;
        boolean isWord;
        Node() {
            isWord = false;
            next = new Node[26];
        }
    }

    Node root = new Node();
    
    public void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    public List<String> find(String s) {
        if (s.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) return res;
            cur.append(c);
            node = node.next[c - 'a'];
        }
        backtrack(cur, node, res);
        return res;
    }

    public void backtrack(StringBuilder cur, Node node, List<String> res) {
        if (res.size() == 3) return;
        if (node.isWord) res.add(cur.toString());
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                cur.append((char)(i + 'a'));
                backtrack(cur, node.next[i], res);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for (String word : products) {
            insert(word);
        }
        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(find(searchWord.substring(0, i)));
        }
        return res;
    }
}