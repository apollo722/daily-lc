/*
https://leetcode.com/problems/redundant-connection-ii/

对于一棵不合法的树，如果有任何一个节点有两个parent，那么指向两个parent的两条边必然有一条是答案
问题是哪条边才是答案？
如果去掉任何一条边树变得合法，那么按照题意，去掉最后出现的指向不同parent的边即可
那如果去掉这个指向第二parent的边树还不合法呢？
这种情况即树还有环（题目保证移掉一条边就能合法，那就只有这一种情况了）
那么可以假定已经移除掉那条指向第二parent的边，如果还有环的话，那么只能说明当时移错边了
应该移除第一条指向parent的边

所以思路是先遍历所有边，找到那条指向第二个parent的边（记作remove），同时记录下子节点与指向的第一个parent形成的边（记作candidate）
之后利用union-find来把除了remove之外的边都连起来
如果任何一条边的两个节点已经连上了，证明发现了环
此时如果candidate存在的话（即找到过remove），那么就要移除candidate，因为忽略remove之后还是有环，证明remove不是产生环的原因，所以要移除当时指向两个parent的另一条边
此时如果candidate不存在，即没有指向两个parent的节点，那么证明最后形成环的这条边就是答案

Time: O(n)
Space: O(n)
*/

class Solution {
    int[] id;
    int[] size;

    private int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private boolean isConnected(int s, int t) {
        return find(s) == find(t);
    }

    private void union(int s, int t) {
        int p = find(s), q = find(t);
        if (p == q) return;
        if (size[p] < size[q]) {
            id[p] = q;
            size[q] += size[p];
        } else {
            id[q] = p;
            size[p] += size[q];
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        id = new int[n + 1];
        size = new int[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            id[i] = i;
            size[i] = 1;
        }
        int remove = -1;
        int[] candidate = new int[2];
        for (int i = 0; i < n; i++) {
            int u = edges[i][0], v = edges[i][1];
            if (parent[v] != 0) {
                remove = i;
                candidate = new int[]{parent[v], v};
                break;
            }
            parent[v] = u;
        }

        for (int i = 0; i < n; i++) {
            if (i == remove) continue;
            int u = edges[i][0], v = edges[i][1];
            if (isConnected(u, v)) {
                if (remove == -1) return edges[i];
                return candidate;
            }
            union(u, v);
        } 

        return edges[remove];
    }
}