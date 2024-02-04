/*
https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

每个位置都从最大的数开始填，来保证最后的结果一定是最大
每次填上一个数，那么另一个它的位置就已经确定，如果在数组范围，就可以直接填上
除非是1，那么就继续看下一位置即可
和传统的backtracking不同的是，这里每次都尽可能地取最大值填充，所以一旦任何一种情况走到底，就直接返回结果而不是继续尝试剩余情况
这样才能节约时间而不跑完所有情况，属于贪心思维
每次尝试一个位置一个数，ok就继续，否则就backtrack

Time: O(n!)
Space: O(n)
*/

class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        build(0, res, visited, n);
        return res;
    }

    private boolean build(int idx, int[] res, boolean[] visited, int n) {
        if (idx == res.length) return true;
        if (res[idx] != 0) return build(idx + 1, res, visited, n);
        for (int i = n; i >= 1; i--) {
            if (visited[i]) continue;
            res[idx] = i;
            visited[i] = true;
            if (i == 1) {
                if (build(idx + 1, res, visited, n)) return true;
            }
            else if (i + idx < res.length && res[i + idx] == 0) {
                res[i + idx] = i;
                if (build(idx + 1, res, visited, n)) return true;
                res[i + idx] = 0;
            }
            res[idx] = 0;
            visited[i] = false;
        }
        return false;
    }
}