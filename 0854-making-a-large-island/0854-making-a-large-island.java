class Solution {
    int[] id;
    int[] sz;
    int[] dir = {-1, 0, 1, 0, -1};
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        id = new int[n * n];
        sz = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                id[i * n + j] = i * n + j;
                if (grid[i][j] == 1) {
                    sz[i * n + j] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                }
            }
        }
        boolean hasZero = false;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    int area = 1;
                    HashSet<Integer> set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int x = i + dir[d], y = j + dir[d + 1];
                        if (x >= 0 && y >= 0 && x < n && y < n) {
                            set.add(find(x * n + y));
                        }
                    }
                    for (int cId : set) area += sz[cId];
                    res = Math.max(res, area);
                }
            }
        }
        if (!hasZero) return n * n;
        return res;
    }

    private void dfs(int[][] grid, int r, int c) {
        int n = grid.length;
        grid[r][c] = -1;
        for (int d = 0; d < 4; d++) {
            int i = dir[d] + r, j = dir[d + 1] + c;
            int cId = n * r + c, nId = i * n + j;
            if (i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 1) {
                union(cId, nId);
                dfs(grid, i, j);
            }
        }
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

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
}