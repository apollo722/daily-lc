/*
https://leetcode.com/problems/minimum-path-sum/

标准DP
也可以利用输入的空间存储结果做到O(1) space

Time: O(n^2)
Space: O(n)
*/

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = j > 0 ? dp[j - 1] + grid[i][j] : grid[i][j];
                } else {
                    dp[j] = j > 0 ? Math.min(dp[j], dp[j - 1]) + grid[i][j] : grid[i][j] + dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}