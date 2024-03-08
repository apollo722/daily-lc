/*
https://leetcode.com/problems/number-of-enclaves/

BFS模板
先把边界都放到q中，之后BFS
剩下没被标记的值为1的个数即为结果

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) q.add(new int[]{0, i});
            if (m - 1 > 0 && grid[m - 1][i] == 1) q.add(new int[]{m - 1, i});
        }
        for (int i = 1; i < m - 1; i++) {
            if (grid[i][0] == 1) q.add(new int[]{i, 0});
            if (n - 1 > 0 && grid[i][n - 1] == 1) q.add(new int[]{i, n -1});
        }
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if (grid[x][y] == 0) continue;
            grid[x][y] = 0;
            for (int d = 0; d < 4; d++) {
                int i = dir[d] + x, j = dir[d + 1] + y;
                if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 1) res++;
            }
        }
        return res;
    }
}