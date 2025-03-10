class Solution {
    int[] dir = {-1, 0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int r, int c, int m, int n) {
        if (r >= m || r < 0 || c >= n || c < 0 || grid[r][c] != '1') return;
        grid[r][c] = '2';
        for (int d = 0; d < 4; d++) {
            dfs(grid, r + dir[d], c + dir[d + 1], m, n);
        }
    }
}