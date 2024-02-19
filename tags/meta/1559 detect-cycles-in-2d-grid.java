/*
https://leetcode.com/problems/detect-cycles-in-2d-grid/

union-find模板
和普通dfs，union-find的区别就是不能走上一步来时的路
稍加变化，每次只走一个方向，即只检查左和上，这样如果存在环，还是能碰到已经visited过的地方且不用担心走来时路

Time: O(mn)
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

    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        id = new int[m * n];
        sz = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && grid[i][j] == grid[i - 1][j]) {
                    int pId = i * n + j, qId = (i - 1) * n + j;
                    if (isConnected(pId, qId)) return true;
                    union(pId, qId);
                }
                if (j > 0 && grid[i][j] == grid[i][j - 1]) {
                    int pId = i * n + j, qId = i * n + j - 1;
                    if (isConnected(pId, qId)) return true;
                    union(pId, qId);
                }
            }
        }
        return false;
    }
}