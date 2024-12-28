/*
https://leetcode.com/problems/maximal-square/

标准DP，可以进一步优化成O(n)空间
题目要求square，即正方形
如果一个位置可以组成正方形，那么左，左上，上，都必须是1，否则新正方形边长一定只是1
dp[i][j]存储(i,j)处能组成正方形的最大边长，那么每个位置能组成的最大边长即左，左上，上的最小值+1，如果当前位置是个1的话

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curMin = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                if (matrix[i - 1][j - 1] == '1') dp[i][j] = curMin + 1;
                res = Math.max(res, dp[i][j] * dp[i][j]);
            }
        }
        return res;
    }
}