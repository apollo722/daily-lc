/*
https://leetcode.com/problems/graph-valid-tree/

union find模板
构成树需要图内没有环，即每条边的两个节点不能已经相连
最后也要统计所有节点是否只能形成一个树，即看最后是否所有节点都只有一个root祖先

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] id, sz;
    int count;
    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private boolean union(int p, int q) {
        int pId = find(p), qId = find(q);
        if (pId == qId) return false;
        if (sz[pId] < sz[qId]) {
            sz[qId] += sz[pId];
            id[pId] = qId;
        } else {
            sz[pId] += sz[qId];
            id[qId] = pId;
        }
        count--;
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int[] e : edges) {
            if(!union(e[0], e[1])) return false;
        }
        return count == 1;
    }
}