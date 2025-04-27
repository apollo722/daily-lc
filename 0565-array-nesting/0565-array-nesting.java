class Solution {
    int[] id, sz;
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
            id[p] = id[id[p]];
        }
        return p;
    }

    public void union(int p, int q) {
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

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        id = new int[n];
        sz = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while (!isConnected(cur, nums[cur])) {
                union(cur, nums[cur]);
                cur = nums[cur];
            }
        }
        int max = 0;
        for (int num : sz) if (max < num) max = num;
        return max;
    }
}