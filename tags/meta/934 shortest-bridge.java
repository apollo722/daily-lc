/*
https://leetcode.com/problems/shortest-bridge/

先用一次dfs把其中一座岛标记出来，并把它放到queue中准备bfs
bfs过程中，只要找到另一座岛上的元素就返回距离

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    flag = true;
                }
                if (flag) break;
            }
            if (flag) break;
        }
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nextI = dir[d] + cur[0], nextJ = dir[d + 1] + cur[1];
                    if (nextI >= 0 && nextI < n && nextJ >= 0 && nextJ < n && grid[nextI][nextJ] != 2) {
                        if (grid[nextI][nextJ] == 1) return res - 1;
                        grid[nextI][nextJ] = 2;
                        q.add(new int[]{nextI, nextJ});
                    }
                }
            }
        }
        return -1;
    }

    private void dfs(int i, int j, int[][] grid) {
        int n = grid.length;
        if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 1) {
            grid[i][j] = 2;
            dfs(i, j + 1, grid);
            dfs(i - 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i + 1, j, grid);
        }
    }
}