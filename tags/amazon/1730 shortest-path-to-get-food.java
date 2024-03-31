/*
https://leetcode.com/problems/shortest-path-to-get-food/

BFS模板

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int getFood(char[][] grid) {
        int[] dir = {-1, 0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '*') {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int[] next = new int[]{cur[0] + dir[d], cur[1] + dir[d + 1]};
                    if (next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && !visited[next[0]][next[1]] && grid[next[0]][next[1]] != 'X') {
                        if (grid[next[0]][next[1]] == '#') return res;
                        visited[next[0]][next[1]] = true;
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }
}