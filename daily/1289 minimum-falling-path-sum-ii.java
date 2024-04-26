/*
https://leetcode.com/problems/minimum-falling-path-sum-ii/

想要每个格子尽量小，那就尽量加上前一行最小的那个元素
如果恰好是同一个col，那也要加上次小的元素
所以只需要保证知道每一行最小的两个元素是谁即可
dp可以进一步优化成1维

Time: O(n^2)
Space: O(n^2)
*/

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int[][] dp = new int[n][n];
        int min1 = -1, min2 = -1;
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = grid[n - 1][i];
            if (min1 == -1 || dp[n - 1][i] <= dp[n - 1][min1]) {
                min2 = min1;
                min1 = i;
            } else if (min2 == -1 || dp[n - 1][i] <= dp[n - 1][i]) min2 = i;
        }
        for (int i = n - 2; i >= 0; i--) {
            int curMin1 = -1, curMin2 = -1;
            for (int j = 0; j < n; j++) {
                if (j != min1) {
                    dp[i][j] = grid[i][j] + dp[i + 1][min1];
                } else {
                    dp[i][j] = grid[i][j] + dp[i + 1][min2];
                }
                if (curMin1 == -1 || dp[i][j] <= dp[i][curMin1]) {
                    curMin2 = curMin1;
                    curMin1 = j;
                } else if (curMin2 == -1 || dp[i][j] <= dp[i][curMin2]) curMin2 = j;
            }
            min1 = curMin1;
            min2 = curMin2;
        }
        return dp[0][min1];
        
    }
}