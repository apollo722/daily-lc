/*
https://leetcode.com/problems/search-suggestions-system/

标准Trie应用+backtrack找每一个前缀

Time: O(m)，m为products中总共有多少个字母，对于找前缀，最多O(len(prefix))，不会比构建Trie更耗时
Space: O(n)，n是num of node in trie

也可以对products排序，之后用two ptr掐住头尾
对于每个前缀都可以缩小头尾的ptr，以O(n)，n为product长度，为代价搜索整个list（字符串match还是需要O(len(prefix))）
每个前缀都从当前的A ptr开始向下（直到3或者B ptr）找三个共享前缀的即可
举例：
banana <= A
m
map
mobile
mouse
zebra <= B

Index 0, [m]onth:
banana (index 0 != 'm')
m <= A
map
mobile
mouse <= B
zebra (index 0 != 'm')

Index 1, m[o]nth
banana
m (length <= 1, so won't have an index 1 to match)
map (index 1 != 'o')
mobile <= A
mouse <= B
zebra

Index 2, mo[n]th (as we try to move pointer A, we go past B, meaning that we will no longer have any matches going forward):
banana
m
map
mobile (index 2 != 'n')
mouse <= B (index 2 != 'n')
zebra <= A
*/

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

    private void insert(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    private void backtrack(StringBuilder curStr, Node node, List<String> res) {
        if (res.size() == 3) return;
        if (node.isWord) res.add(curStr.toString());
        for (int i = 0; i < 26; i++) {
            if (node.next[i] != null) {
                curStr.append((char)(i + 'a'));
                backtrack(curStr, node.next[i], res);
                curStr.deleteCharAt(curStr.length() - 1);
            }
        }
    }

    private List<String> find(String s) {
        if (s.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        StringBuilder curStr = new StringBuilder();
        Node node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) return res;
            curStr.append(c);
            node = node.next[c - 'a'];
        }
        backtrack(curStr, node, res);
        return res;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        for (String word : products) insert(word);
        for (int i = 1; i <= searchWord.length(); i++) {
            res.add(find(searchWord.substring(0, i)));
        }
        return res;
    }
}