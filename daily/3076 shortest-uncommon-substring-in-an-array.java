/*
https://leetcode.com/problems/shortest-uncommon-substring-in-an-array/

利用trie存储每个substring，作为map
随后对每一个str的所有substr建立一个新的trie
如果任何一个substr在trie中的节点的cnt数和map trie相等，证明没有其它str的substr出现过这个substr
使它成为了一个candidate

Time: 
Space: 
*/

class Solution {
    class Node {
        Node[] next;
        int cnt;
        Node() {
            next = new Node[26];
            cnt = 0;
        }
    }
    Node root;
    private void insert(String s) {
        for (int i = 0; i < s.length(); i++) {
            Node node = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
                node.next[c - 'a'].cnt++;
                node = node.next[c - 'a'];
            }
        }
    }
    public String[] shortestSubstrings(String[] arr) {
        root = new Node();
        String[] res = new String[arr.length];
        for (String s : arr) insert(s);
        for (int i = 0; i < arr.length; i++) {
            String curString = arr[i];
            res[i] = "";
            Node cur = new Node();
            for (int j = 0; j < curString.length(); j++) {
                Node node = root;
                Node curNode = cur;
                for (int k = j; k < curString.length(); k++) {
                    char c = curString.charAt(k);
                    if (curNode.next[c - 'a'] == null) curNode.next[c - 'a'] = new Node();
                    curNode.next[c - 'a'].cnt++;
                    if (node.next[c - 'a'] == null) continue;
                    if (node.next[c - 'a'].cnt == curNode.next[c - 'a'].cnt) {
                        int len = k - j + 1;
                        String candidate = arr[i].substring(j, k + 1);
                        if (res[i].equals("") || candidate.length() < res[i].length() || (candidate.length() == res[i].length() && candidate.compareTo(res[i]) < 0)) {
                            res[i] = candidate;
                        }
                    } else node = node.next[c - 'a'];
                    curNode = curNode.next[c - 'a'];
                }
            }
        }
        return res;
    }
}