/*
https://leetcode.com/problems/redundant-connection/

union-find模板
注意题目找的是最后一条多余边，所以还是要扫描所有的边，记录最后一条多余的边并返回

Time: O(n)
Space: O(n)
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

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        id = new int[n + 1];
        sz = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        int[] res = new int[2];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            if (isConnected(u, v)) res = e;
            else union(u, v);
        }
        return res;
    }
}