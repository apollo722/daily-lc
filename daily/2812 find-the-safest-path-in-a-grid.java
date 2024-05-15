/*
https://leetcode.com/problems/find-the-safest-path-in-a-grid/

先用BFS把所有格子的score求出来
之后用最短路径，只不过此时是最长路径，dijkstra算法求出结果

Time: O(n^2 logn)
Space: O(n^2)
*/

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] m = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    m[i][j] = 0;
                } else m[i][j] = -1;
            }
        }
        int[] dir = {-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                for (int d = 0; d < 4; d++) {
                    int x = dir[d] + cur[0], y = dir[d + 1] + cur[1];
                    int val = m[cur[0]][cur[1]];
                    if (x >= 0 && y >= 0 && x < n && y < n && m[x][y] == -1) {
                        m[x][y] = val + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, m[0][0]});
        m[0][0] = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == n - 1 && cur[1] == n - 1) return cur[2];
            for (int d = 0; d < 4; d++) {
                int x = cur[0] + dir[d], y = cur[1] + dir[d + 1];
                if (x >= 0 && y >= 0 && x < n && y < n && m[x][y] != -1) {
                    pq.add(new int[]{x, y, Math.min(cur[2], m[x][y])});
                    m[x][y] = -1;
                }
            }
        }
        return -1;
    }
}