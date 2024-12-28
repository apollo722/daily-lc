/*
https://leetcode.com/problems/number-of-islands-ii/

标准union-find
每一个坐标出现之后原本都会增加一个岛
这时要检查四周看能不能连上其它岛，如果可以连到没有连过的，就要减掉总岛数

Time: O(mn)
Space: O(mn)
*/

class Solution {
    int[] id;
    int[] sz;
    int connect = 0;
    private int find(int p) {
        while (p != id[p]) p = id[p];
        return id[p];
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
        connect++;
    }

    private int count() {  return connect;  }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int N = m * n;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        List<Integer> res = new ArrayList<>();
        int curIsland = 0;
        int[] dir = {-1, 0, 1, 0, -1};
        int[][] board = new int[m][n];
        for (int[] position : positions) {
            int i = position[0], j = position[1];
            if (board[i][j] == 1) {
                res.add(curIsland - count());
                continue;
            }
            board[i][j] = 1;
            curIsland++;
            for (int d = 0; d < 4; d++) {
                int x = i + dir[d], y = j + dir[d + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 1) {
                    union(i * n + j, x * n + y);
                }
            }
            res.add(curIsland - count());
        }
        
        return res;
    }
}