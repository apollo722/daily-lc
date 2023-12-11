/*
https://leetcode.com/problems/shortest-path-in-binary-matrix/

BFS模板，探索8个方向，注意初始和结束的格子不能是1

Time: O(n^2)
Space: O(n^2)，最worst的情况一轮下来所有的cell都在q中
*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (n == 1 && grid[0][0] == 0) return 1;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[] dir = {-1, 0, 1, 0, -1, 1, 1, -1, -1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        int res = 1;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 8; d++) {
                    int i = cur[0] + dir[d], j = cur[1] + dir[d + 1];
                    if (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0) {
                        if (i == n - 1 && j == n - 1) return res;
                        grid[i][j] = 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }
        return -1;
    }
}