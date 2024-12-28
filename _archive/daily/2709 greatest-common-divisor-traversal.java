/*
https://leetcode.com/problems/greatest-common-divisor-traversal/

连接图的问题，满足gcd条件的两个位置时连通的话，最后的要求是所有元素都在一张图里
所以可以O(n^2)的求出每对元素是否连通，并用union-find来看最后是否所有元素都是同一个id
如果n很大的话这样做成本很高，可以取巧用质数筛来把所有元素的质数因数求出来，之后只把它和其质数因数连起来
这样连通性不会遭到破坏，即两个不同元素如果链接到同一个质数因数，那么他们两个也是相连的
所以就相当于从2开始把所有小于max，max即元素中最大值，的质因数都写出来
对于输入的每一个元素，把它所有的质因数写出来后，利用uf相连
最后看有多少不同id即可

举例子，[2,3,6]
2有质因数2
3有质因数3
6有质因数2，3
2-2, 3-3, 6-2, 6-3，故所有元素都是连通的

有一个edge case是如果元素中含有1，它不可能和任何元素的gcd大于1，故直接返回false

Time: O(nlog(max))，题目的max有上限，所以质数个数也有上限，最多n*质数个数条边，构建图最多O(nlog(max))，UF的操作是O(max + n)
Space: O(n)
*/

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int max = nums[0], n = nums.length;
        if (n == 1) return true;
        for (int num : nums) {
            if (num == 1) return false;
            max = Math.max(max, num);
        }
        int[] factor = new int[max + 1];
        for (int p = 2; p <= max; p++) {
            if (factor[p] == 0) {
                for (int mp = p; mp <= max; mp += p) factor[mp] = p;
            }
        }
        UnionFind uf = new UnionFind(max + 1);
        for (int num : nums) {
            int cur = num;
            while (cur > 1) {
                int p = factor[cur];
                uf.union(p, num);
                while (cur % p == 0) cur /= p;
            }
        }
        int key = uf.find(nums[0]);
        for (int num : nums) {
            if (key != uf.find(num)) return false;
        }
        return true;
    }

    class UnionFind {
        int[] id, sz;
        public UnionFind(int n) {
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                sz[i] = 1;
                id[i] = i;
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
    }
}