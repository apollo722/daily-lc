/*
https://leetcode.com/problems/unique-paths-ii/

space optimized dp
如果一个cell是obstacle，路径为0
否则计算它上和左的路径和
注意初始和结束的cell不能为obstacle

Time: O(mn)
Space: O(n)
*/

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0; 
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1) dp[i] = 0;
            else {
                dp[i] = dp[i - 1];
            }
        }
        for (int i = 1; i < m; i++) {
            int[] cur = dp.clone();
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    cur[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j];
                } else {
                    cur[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j] + cur[j - 1];
                }
            }
            dp = cur;
        }
        return dp[n - 1];
    }
}