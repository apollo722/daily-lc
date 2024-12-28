/*
https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/

标准union-find模板

Time: O(n + e)
Space: O(n)
*/

class Solution {
    int[] id;
    int[] sz;
    int cnt;
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
        cnt--;

    }
    public int countComponents(int n, int[][] edges) {
        id = new int[n];
        sz = new int[n];
        cnt = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        return cnt;
    }
}