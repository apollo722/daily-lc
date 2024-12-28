/*
https://leetcode.com/problems/swim-in-rising-water/

union-find模板
题目等于变相找到一个格子使得左上和右下连起来
随着时间的推移，格子的值从小到大就可以逐渐的游到，而每次游到格子，可以尝试向四个方向游去
如果任何一个方向之前已经游到了，那就将它们连起来
从小到大来扫描，直到某一时刻左上右下相连了，那个时刻就是最后所求

Time: O(mnlog(mn))
Space: O(mn)
*/

class Solution {
    int[] id, sz;
    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union(int p, int q) {
        int pId = find(p), qId = find(q);
        if (pId == qId) return;
        if (sz[pId] < sz[qId]) {
            sz[qId] += sz[pId];
            id[pId] = qId;
        } else {
            sz[pId] += sz[qId];
            id[qId] = pId;
        }
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int swimInWater(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        id = new int[m * n];
        sz = new int[m * n];
        int[][] weight = new int[m * n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curId = i * n + j;
                sz[curId] = 1;
                id[curId] = curId;
                weight[curId][0] = i;
                weight[curId][1] = j;
                weight[curId][2] = grid[i][j];
            }
        }
        Arrays.sort(weight, (a, b) -> Integer.compare(a[2], b[2]));
        boolean[][] visited = new boolean[m][n];
        int[] dir = {-1, 0, 1, 0, -1};
        for (int k = 0; k < m * n; k++) {
            int i = weight[k][0], j = weight[k][1], t = weight[k][2];
            visited[i][j] = true;
            for (int d = 0; d < 4; d++) {
                int x = dir[d] + i, y = dir[d + 1] + j;
                if (x >= 0 && x < m && y >= 0 && y < n && visited[x][y]) {
                    union(i * n + j, x * n + y);
                }
            }
            if (isConnected(0, m * n - 1)) return t;
        }
        return -1;
    }
}