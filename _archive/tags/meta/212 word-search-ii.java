/*
https://leetcode.com/problems/word-search-ii/

利用trie把所有的word放到字典
利用dfs对每个位置进行backtrack的搜索
每次找到单词之后，为了加速，可以把单词从字典中删除，即利用node.count

Time: O(mn 4 x 3^(l - 1))，l为单词平均长度，这是因为对于mn个cell，每个cell都需要dfs探索四个方向，之后每个方向再探索3个方向
Space: O(kl)，k为单词个数，l为单词平均长度
*/

class Solution {
    class Node {
        int count;
        boolean isWord;
        Node[] next;
        Node() {
            this.isWord = false;
            next = new Node[26];
            count = 0;
        }
    }

    Node root = new Node();

    private void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] == null) node.next[c - 'a'] = new Node();
            node = node.next[c - 'a'];
            node.count++;
        }
        node.isWord = true;
    }

    private void remove(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {            
            node = node.next[c - 'a'];
            node.count--;
        }
        node.isWord = false;
    }

    List<String> res = new ArrayList<>();
    int m, n;
    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) insert(w);
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;
                dfs(root, board, i, j, new StringBuilder(), visited);
            }
        }
        return res;
    }

    int[] dir = {-1, 0, 1, 0, -1};

    private void dfs(Node node, char[][] board, int r, int c, StringBuilder curStr, boolean[][] visited) {
        char cur = board[r][c];
        if (node.next[cur - 'a'] == null || node.next[cur - 'a'].count == 0) return;
        node = node.next[cur - 'a'];
        curStr.append(cur);
        if (node.isWord) {
            remove(curStr.toString());
            res.add(curStr.toString());
        }
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                visited[i][j] = true;
                dfs(node, board, i, j, curStr, visited);
                visited[i][j] = false;
            }
        }
        curStr.deleteCharAt(curStr.length() - 1);
    }
}