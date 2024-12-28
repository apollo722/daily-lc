/*
https://leetcode.com/problems/sum-of-prefix-scores-of-strings/

Trie的应用
常规构建Trie，其中每个节点记录当前节点下有多少个单词
求解的时候，只要顺序的查找，把单词的每个字符所在节点的单词数加到结果即可
可以做优化剪枝，即当扫描到某个字符的时候，单词数如果已经是1了，那么余下的字符一定也是1，就没必要继续计算了，算下剩下的字符数就好

Time: O(mn)，m为单词平均长度
Space: O(mn)
*/

class Solution {
    class Trie {
        class Node {
            int count;
            Node[] next;
            public Node() {
                int count = 0;
                next = new Node[26];
            }
        }
        public Trie() {
            root = new Node();
        }
        Node root;
        public void add(String s) {
            Node node = root;
            for (char c : s.toCharArray()) {
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
                node = node.next[c - 'a'];
                node.count++;
            }
        }
        public int count(String s) {
            Node node = root;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (node.next[c - 'a'] == null) return res;
                node = node.next[c - 'a'];
                if (node.count == 1) {
                    res += s.length() - i;
                    return res;
                }
                res += node.count;
            }
            return res;
        }
    }

    HashMap<String, Integer> m = new HashMap<>();
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        for (String w : words) trie.add(w);
        int n = words.length, idx = 0;
        int[] res = new int[n];
        for (String w : words) {
            res[idx] = trie.count(w);
            idx++;
        }
        return res;
    }
}