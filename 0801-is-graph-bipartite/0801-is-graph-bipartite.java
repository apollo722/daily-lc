class Solution {
    int[] id, sz;
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

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                if (isConnected(i, j)) return false;
                union(j, graph[i][0]);
            }
        }
        return true;
    }
}


/*
二分图问题（bipartition/bipartite）。
二分图即图中所有节点都可以分到两个组，并且每一条边的两个节点都分别在不同组里。
也就是说，任意一个节点的所有neighbor都是同一个组的，而这个父节点和其所有neighbor都不同组。
利用union-find，遍历所有节点的时候，检查父节点和子节点是否同组。
若不同组，把子节点都union起来。union子节点的时候选一个代表即可，即graph[i][0]。
意思是所有的子节点都和父节点的第一个子节点相连，也就是所有子节点都相连了。
*/