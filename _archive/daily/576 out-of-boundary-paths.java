/*
https://leetcode.com/problems/out-of-boundary-paths/

没有更好的算法，只有每个都走一遍，利用memo记住每一个状态的结果

Time: O(maxMove mn)
Space: O(maxMove mn)
*/

class Solution {
    int[][][] memo;
    int mod = 1_000_000_007;
    int[] dir = {-1, 0, 1, 0, -1};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
        for (int[][] mem : memo) {
            for (int[] me : mem) Arrays.fill(me, -1);
        }
        return calc(m, n, maxMove, startRow, startColumn);
    }

    private int calc(int m, int n, int N, int i, int j) {
        if (i == m || j == n || i < 0 || j < 0) return 1;
        if (N == 0) return 0;
        if (memo[i][j][N] >= 0) return memo[i][j][N];
        memo[i][j][N] = 0;
        for (int d = 0; d < 4; d++) {
            memo[i][j][N] += calc(m, n, N - 1, i + dir[d], j + dir[d + 1]) % mod;
            memo[i][j][N] %= mod;
        }
        return memo[i][j][N];
    }
}