/*
https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

正反两次扫描
假设dp[i][j]为以(i, j)为顶点的金字塔的深度
那么当其自己，正下方都为1时，其深度为min(dp[i+1][j-1], dp[i+1][j+1])+1
（以上解释为寻找正金字塔，且需要反着扫描，以下实现是寻找反金字塔正向扫描）

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int countPyramids(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rev = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                rev[m - i - 1][j] = grid[i][j];
            }
        }
        return count(grid) + count(rev);
    }

    private int count(int[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) continue;
                if (i == 0) dp[i][j] = grid[i][j];
                else if (j > 0 && j < n - 1) {
                    if (grid[i - 1][j] == 0) dp[i][j] = grid[i][j];
                    else dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + 1;
                } else dp[i][j] = grid[i][j];
                if (dp[i][j] >= 2) res += dp[i][j] - 1;
            }
        }
        return res;
    }
}