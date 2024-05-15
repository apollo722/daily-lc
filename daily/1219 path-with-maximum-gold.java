/*
https://leetcode.com/problems/path-with-maximum-gold/

dfs模板，带backtracking找到最大的即可

Time: O(mn 4^g)，g为金格子总数
Space: O(4^g)
*/

class Solution {
    int res = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(i, j, grid, 0);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, int[][] grid, int sum) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 0) {
            res = Math.max(res, sum);
            return;
        }
        int val = grid[i][j];
        sum += val;
        grid[i][j] = 0;
        dfs(i + 1, j, grid, sum);
        dfs(i - 1, j, grid, sum);
        dfs(i, j + 1, grid, sum);
        dfs(i, j - 1, grid, sum);
        grid[i][j] = val;
    }
}