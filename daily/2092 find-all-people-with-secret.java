/*
https://leetcode.com/problems/find-all-people-with-secret/

union-find模板，但是有小小的更改
每次扫描相同t时刻的meeting（所以需要排序），把所有meeting进行union
但是这样union并不保证他们都在此时刻知道秘密，因为可能整个连接的部分都没有连接到已经知道秘密的人
所以需要重新扫描一下当前t时刻的所有meeting，如果他们任何一个人没有和0相连，需要reset这次的union
reset union只需要将id[p]重置为p，sz[p]重置为1即可
最后扫描所有人，和0连通的加入结果

Time: O(n + mlogm + m)，排序需要mlogm，union-find建立需要n，扫描meeting时每个meeting最多只被扫描两次，故为m
Space: O(n + logm)，排序需要logm的复杂度
*/

class Solution {
    class UnionFind {
        int[] id, sz;
        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int p) {
            while (p != id[p]) p = id[p];
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

        public void reset(int p) {
            id[p] = p;
            sz[p] = 1;
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        int l = 0, r = 0;
        while (l < meetings.length) {
            r = l;
            while (r < meetings.length && meetings[l][2] == meetings[r][2]) {
                uf.union(meetings[r][0], meetings[r][1]);
                r++;
            }
            for (int k = l; k < r; k++) {
                int[] curM = meetings[k];
                int u = curM[0], v = curM[1];
                if (!uf.isConnected(u, 0)) {
                    uf.reset(u);
                    uf.reset(v);
                }
            }
            l = r;
        }    
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.isConnected(0, i)) res.add(i);
        }
        return res;
    }
}