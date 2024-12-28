/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/

标准Trie模板，只是search word with dot的时候要检查node的每一个节点，返回任何一个true的情况，否则返回false

Time: insert: O(m), search: O(m) for word without dot，m是key length，O(n 26^m) for word with dot
Space: insert: O(m), search: O(1)/O(m)
*/

class WordDictionary {
    class Node {
        boolean isWord;
        Node[] next;
        public Node() {
            this.isWord = false;
            this.next = new Node[26];
        }
    }

    Node root = new Node();

    public WordDictionary() {
        
    }
    
    public void addWord(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node(); 
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, Node node) {
        if (node == null) return false;
        if (idx == word.length()) return node.isWord;
        char c = word.charAt(idx);
        if (word.charAt(idx) != '.') {
            if (node.next[c - 'a'] == null) return false;
            return search(word, idx + 1, node.next[c - 'a']);
        } else {
            for (int i = 0; i < 26; i++) {
                if (search(word, idx + 1, node.next[i])) return true;
            }
        }
        return false;
    }
}