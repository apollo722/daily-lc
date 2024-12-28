/*
https://leetcode.com/problems/regions-cut-by-slashes/

比较难以具象到算法的一道题
什么样的情况能形成一个新的区域？首先一开始的巨大正方形本身是一个大区域，因为四边合围成了区域
如果任何一个时刻，一条斜线形成了闭环，那么就相当于新增了一个区域
形成闭环就想到了用union find来判断，即如果两个节点之前已经相连了，证明形成了闭环，那么区域就应该+1
所以把每一个可能的节点都具象成一个元素，比如一开始n=2时，会产生总计3x3的节点
0 1 2
3 4 5
6 7 8
先把四条边都连起来，之后设置区域数为1
之后依次根据/或者\的情况将对应元素连起来，当检测到环的时候，区域+1即可

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    int[] id;
    int[] sz;
    int res = 1;
    private int find(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int pId = find(p), qId = find(q);
        if (pId == qId) {
            res++;
            return;
        }
        if (sz[pId] < sz[qId]) {
            sz[qId] += sz[pId];
            id[pId] = qId;
        } else {
            sz[pId] += sz[qId];
            id[qId] = pId;
        }
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length + 1;
        id = new int[n * n];
        sz = new int[n * n];
        for (int i = 0; i < n * n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            union(0, i);
            union((n - 1) * n, (n - 1) * n + i);
        }
        for (int i = 1; i < n; i++) {
            union(0, i * n);
            union(n - 1, (n - 1) + i * n);
        }
        res = 1;
        for (int i = 0; i < n - 1; i++) {
            String cur = grid[i];
            for (int j = 0; j < n - 1; j++) {
                char c = cur.charAt(j);
                if (c == '/') {
                    union(n * i + j + 1, (i + 1) * n + j);
                } else if (c == '\\') {
                    union(n * i + j, (i + 1) * n + j + 1);
                }
            }
        }
        return res;
    }
}