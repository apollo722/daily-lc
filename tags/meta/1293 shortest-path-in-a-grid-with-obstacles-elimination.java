/*
https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

BFS模板
和常规bfs不同的是每一个cell可能有k个状态
那就用数组把所有可能的状态都存起来，之后常规bfs即可，即如果遇到的cell是1，那么看当时k的情况来产生新的状态
否则就是正常的入队列出队列

Time: O(mnk)
Space: O(mnk)
*/

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        boolean[][][] visited = new boolean[m + 1][n + 1][k + 1];
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        q.add(new int[]{0, 0, k});
        visited[0][0][k] = true;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int curX = cur[0], curY = cur[1], curK = cur[2];
                for (int d = 0; d < 4; d++) {
                    int nextX = curX + dir[d], nextY = curY + dir[d + 1];
                    if (nextX == m - 1 && nextY == n - 1) return res;
                    if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n) continue;
                    if (grid[nextX][nextY] == 1) {
                        if (curK <= 0) continue;
                        if (!visited[nextX][nextY][curK - 1]) {
                            visited[nextX][nextY][curK - 1] = true;
                            q.add(new int[]{nextX, nextY, curK - 1});
                        }
                    } else {
                        if (!visited[nextX][nextY][curK]) {
                            visited[nextX][nextY][curK] = true;
                            q.add(new int[]{nextX, nextY, curK});
                        }
                    }
                }
            }
        }
        return -1;
    }
}