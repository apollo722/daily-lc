/*
https://leetcode.com/problems/word-search/

backtrack模板，用dfs的方式对所有方向逐个检查即可

Time: O(mn 4x3^(l - 1))，l为单词长度
Space: O(l)
*/

class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String s, int idx) {
        if (idx == s.length()) return true;
        int m = board.length, n = board[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] == '#' || s.charAt(idx) != board[row][col]) return false;
        board[row][col] = '#';
        for (int d = 0; d < 4; d++) {
            int i = row + dir[d], j = col + dir[d + 1];
            if (dfs(board, i, j, s, idx + 1)) return true;
        }
        board[row][col] = s.charAt(idx);
        return false;
    }
}