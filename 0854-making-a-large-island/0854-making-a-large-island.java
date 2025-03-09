class Solution {
    int[] id, sz;
    int[] dir = {-1, 0, 1, 0, -1};
    private int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
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

    public int largestIsland(int[][] grid) {
        int n = grid.length, res = 0;
        id = new int[n * n];
        sz = new int[n * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sz[i * n + j] = 1;
                }
                id[i * n + j] = i * n + j;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    int curId = i * n + j;
                    for (int d = 0; d < 4; d++) {
                        int x = dir[d] + i, y = dir[d + 1] + j;
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1) {
                            union(curId, x * n + y);
                        } 
                    }
                }
            }
        }
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    int curArea = 1;
                    HashSet<Integer> set = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int x = dir[d] + i, y = dir[d + 1] + j;
                        int nextId = x * n + y;
                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            set.add(find(nextId));
                        }
                    }
                    for (int island : set) {
                        curArea += sz[island];
                    }
                    res = Math.max(res, curArea);
                }
            }
        }
        if (!hasZero) return n * n;
        return res;
    }
}


/*
union find模板。
先DFS把所有岛连起来，计算每个岛的面积。这样每个岛都会有一个专属id。
之后扫描每个0点，对其四周的岛找到他们的id。对于每个独特的id把面积加起来。
最后最大的就是答案。
*/