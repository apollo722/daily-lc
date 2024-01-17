/*
https://leetcode.com/problems/implement-trie-prefix-tree/

字典树Trie模板

Time: O(n)，n为输入单词的总长
Space: O(n)
*/

class Trie {
    class Node {
        Node[] next;
        boolean isWord;
        Node () {
            isWord = false;
            next = new Node[26];
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for (char c : prefix.toCharArray()) {
            if (node.next[c - 'a'] == null) return false;
            node = node.next[c - 'a'];
        }
        return true;
    }
}