/*
https://leetcode.com/problems/max-area-of-island/

DFS模板

Time: O(mn)
Space: O(1)
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    int[] dir = {-1, 0, 1, 0, -1};
    private int dfs(int[][] grid, int r, int c) {
        int res = 1, m = grid.length, n = grid[0].length;
        grid[r][c] = 2;
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                res += dfs(grid, i, j);
            }
        }
        return res;
    }
}