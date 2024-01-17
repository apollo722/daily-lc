/*
https://leetcode.com/problems/check-knight-tour-configuration/

DFS模板，每次遍历8个方向，找到当前步数的下一个步数继续
找到最后一步的时候标记整体为真即可

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    boolean res = false;
    int[] dirx = {1, 1, -1, -1, 2, 2, -2, -2};
    int[] diry = {2, -2, 2, -2, 1, -1, 1, -1};

    public boolean checkValidGrid(int[][] grid) {
        dfs(0, 0, 0, grid);
        return res;        
    }

    private void dfs(int i, int j, int cur, int[][] grid) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || cur != grid[i][j]) return;
        if (cur == n * n - 1) {
            res = true;
            return;
        }
        for (int d = 0; d < 8; d++) {
            dfs(dirx[d] + i, diry[d] + j, cur + 1, grid);
        }
    }
}