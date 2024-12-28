/*
https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/

union-find模板
扫描每条边，union每对边，如果最后链接的component变成了1或者边都扫描过了，即退出循环
看最后的结果是否只有一个component即可

Time: O(n + mlogm + mn)
Space: O(n + logm)
*/

class Solution {
    int[] id, sz;
    int count;
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
        count--;
    }

    private boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int earliestAcq(int[][] logs, int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }        
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        int i = 0, len = logs.length;
        while (count != 1 && i < len) {
            int time = logs[i][0], p = logs[i][1], q = logs[i][2];
            if (isConnected(p, q)) {
                i++;
                continue;
            }
            union(p, q);
            i++;
        }
        return count == 1 ? logs[i - 1][0] : -1;
    }
}