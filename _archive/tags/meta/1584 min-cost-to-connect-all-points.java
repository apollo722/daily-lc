/*
https://leetcode.com/problems/min-cost-to-connect-all-points/

最小生成树问题
每次拿两个点都是最小的cost的话，拿完所有点的cost一定是最小
所以先把所有点之间的距离求出来并排序，按照最小顺序拿点
如果某两个点已经被之前的某一步连了起来，即被某两步拿过了，那么就不拿了
可以用union-find来判断某两个点是否已被拿了

有时间更优化的算法https://leetcode.com/problems/min-cost-to-connect-all-points/editorial/

Time: O(n^2 logn)
Space: O(n^2)
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

    private int getDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length, res = 0;
        List<int[]> list = new ArrayList<>();
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
            for (int j = i + 1; j < n; j++) {
                int dist = getDist(points[i], points[j]);
                list.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        for (int i = 0; i < list.size(); i++) {
            int[] cur = list.get(i);
            if (!isConnected(cur[0], cur[1])) {
                res += cur[2];
                union(cur[0], cur[1]);
            }
        }
        return res;
    }
}