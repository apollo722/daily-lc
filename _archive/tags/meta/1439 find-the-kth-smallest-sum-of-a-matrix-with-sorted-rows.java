/*
https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

Reference: https://www.youtube.com/watch?v=y9EzW-S63Vo

一开始想的是暴力解法，即把所有组合求出来之后取第k个，实际上暴力解法也可以优化，即如果前几行组合的和如果已经超过了k个，那就没必要再取了
每推进一行只需要取前k个和去和下面一行组合就行

更进一步是用pq，首先取每行的第一个元素成为组合放入pq中，之后每次poll一个组合，都有m种往下推进的可能，即m行中任意一行向下走1，之后放入pq中
这里注意要去重，因为同一种组合的来源不一定是唯一的，所以需要set来去重组合情况

最后求最小的k之类的题也可以想一下能不能用二分查找
这里直接找那个第k个的和，相当于从1到max_int的二分，最多分32次
对于给定的和，如果mat中组合和的个数大于或者等于k，那么这个和可能是最后的结果
否则证明这个和太小了，需要像右侧查找
那么题目就变成了给定一个数组，找数组中有多少满足题意的组合数的和大于这个和
可以利用dfs的思想每一行的找
一开始所有行的位置都在idx=0处，此时sum是行首和，cnt为1
每一行都向下推进1位，如果能满足条件，证明找到了一个新的组合，那么cnt+1
否则根据dfs，接着向下找的时候，col的idx还是从0开始
这里注意col的idx要大于0时才能计数，是因为比如全0的时候，按照dfs下一个位置是第一行的0，那么这个时候这种情况已经计算在base中了
只有col往后移动到1，即1，0，0...的时候，才是一个新的组合
其它行也一样，即0，1，0...的时候才需要计数，就是因为全0的时候是基础组合，已经计算过了

Time: O(32k)
Space: O(1)
*/

class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int l = 1, r = Integer.MAX_VALUE, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(mat, mid, k)) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }

    private boolean check(int[][] mat, int tar, int k) {
        int m = mat.length, n = mat[0].length, sum = 0;
        for (int i = 0; i < m; i++) {
            sum += mat[i][0];
        }
        if (sum > tar) return false;
        int[] cnt = {1};
        dfs(mat, 0, sum, cnt, tar, k);
        return cnt[0] >= k;
    }

    private void dfs(int[][]mat, int row, int sum, int[] cnt, int tar, int k) {
        int m = mat.length, n = mat[0].length;
        if (cnt[0] >= k) return;
        if (row == m) return;
        for (int col = 0; col < n; col++) {
            if (sum + mat[row][col] - mat[row][0] <= tar) {
                if (col > 0) cnt[0]++;
                dfs(mat, row + 1, sum + mat[row][col] - mat[row][0], cnt, tar, k);
            }
        }
    }
}