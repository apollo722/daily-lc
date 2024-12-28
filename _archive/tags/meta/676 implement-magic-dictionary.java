/*
https://leetcode.com/problems/implement-magic-dictionary/

建立Trie之后利用DFS思想从可能的下一步里找余下的长度

Time: build: O(nw), search: O(26w), w为word长度，因为只有一个diff，一开始最多找26次，一旦set diff，剩下的就是w找到底
Space: O(nw)
*/

class MagicDictionary {
    class Node {
        boolean isWord;
        Node[] next;
        Node () {
            this.next = new Node[26];
        }
    }

    Node root = new Node();
    
    private void insert(String s) {
        Node node = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) insert(s);
    }
    
    public boolean search(String searchWord) {
        return search(searchWord, root, 0, false);
    }

    private boolean search(String s, Node node, int idx, boolean changed) {
        if (node == null) return false;
        if (idx == s.length()) {
            if (!changed) return false;
            return node.isWord;
        }
        if (changed) {
            if (node.next[s.charAt(idx) - 'a'] == null) return false;
            return search(s, node.next[s.charAt(idx) - 'a'], idx + 1, changed);
        } 
        boolean res = false;
        for (int i = 0; i < 26; i++) {
            if (node.next[i] == null) continue;
            res = res || search(s, node.next[i], idx + 1, s.charAt(idx) - 'a' == i ? changed : !changed);
            if (res) return true;
        }
        return false;
    }
}