/*
https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

union find模板
先分析type3，如果一条边第一次链接节点，那它就是必须的
分别建立两张图，只有这条type3的边对任何一张图有贡献那它就是必须的
之后再看其它两个type
最后看两张图是否都被连起来了，如果是，那么就返回总数-必须的边
否则-1

Time: O(ev)
Space: O(v)
*/

class Solution {
    class UnionFind{
        int[] id, sz;
        int cnt;
        public UnionFind(int n) {
            id = new int[n + 1];
            sz = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
            cnt = n;
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public int union(int p, int q) {
            int pId = find(p), qId = find(q);
            if (pId == qId) return 0;
            if (sz[pId] < sz[qId]) {
                sz[pId] += sz[qId];
                id[qId] = pId;
            } else {
                sz[qId] += sz[pId];
                id[pId] = qId;
            }
            cnt--;
            return 1;
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n), bob = new UnionFind(n);
        int needed = 0;
        for (int[] e : edges) {
            int t = e[0], u = e[1], v = e[2];
            if (t == 3) {
                needed += (alice.union(u, v) | bob.union(u, v));
            }
        }
        for (int[] e : edges) {
            int t = e[0], u = e[1], v = e[2];
            if (t == 1) needed += alice.union(u, v);
            else if (t == 2) needed += bob.union(u, v);
        }
        if (alice.cnt == 1 && bob.cnt == 1) return edges.length - needed;
        return -1;
    }
}