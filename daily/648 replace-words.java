/*
https://leetcode.com/problems/replace-words/

trie模板
把词根都放到trie，之后对每个单词都从trie中找一个第一次遇见的单词，并替换

Time: O(w(m + n))，w为word平均长度，m为dict长度，n为句子中单词长度
Space: O(w(m + n))
*/

class Solution {
    class Node {
        boolean isWord;
        Node[] next;
        Node() {
            isWord = false;
            next = new Node[26];
        }
    }
    class Trie {
        Node root;
        Trie() {
            root = new Node();
        } 
        public void insert(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                if (cur.next[c - 'a'] == null) cur.next[c - 'a'] = new Node();
                cur = cur.next[c - 'a'];
            }
            cur.isWord = true;
        }
        public String find(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) return word;
                cur = cur.next[c - 'a'];
                if (cur.isWord) return word.substring(0, i + 1);
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        Trie trie = new Trie();
        for (String word : dictionary) trie.insert(word);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = trie.find(arr[i]);
        }
        return String.join(" ", arr);
    }
}