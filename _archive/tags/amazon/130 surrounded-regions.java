/*
https://leetcode.com/problems/surrounded-regions/

dfs模板
题目表述不是很清楚，要找是“活口”，即没有被X围死的位置
边界属于开口，所以从边界的开口DFS标记所有能连起来的，他们就都是活口
剩下的就都是封闭的

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && board[i][j] == 'O' && !visited[i][j]) {
                    dfs(board, i, j, visited);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != 'O') return;
        visited[i][j] = true;
        dfs(board, i + 1, j, visited);
        dfs(board, i - 1, j, visited);
        dfs(board, i, j + 1, visited);
        dfs(board, i, j - 1, visited);
    }
}