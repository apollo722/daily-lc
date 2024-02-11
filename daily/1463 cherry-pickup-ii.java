/*
https://leetcode.com/problems/cherry-pickup-ii/

两个机器人每一个时刻一定都在同一行，利用dp来逐个状态求解
假设dp[i][j][k]为机器人在(i,j)以及(i,k)处的结果
此行的结果首先要加上两个机器人所在位置的个数，注意如果j==k就只能加一个
每一个位置能收集到的最大值即之前一行的（注意这里从最下面一行开始算）合法范围内的最大值
之后个数的总数，置入dp中
最后答案即为初始位置，即(0,0)与(0,n-1)处的结果

因为每一行的计算结果只取决于上一行，所以可以进一步优化成O(n^2)

Time: O(mn^2)
Space: O(mn^2)
*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    int res = 0;
                    res += grid[i][j];
                    if (j != k) res += grid[i][k];
                    if (i != m - 1) {
                        int max = 0;
                        for (int p1 = j - 1; p1 <= j + 1; p1++) {
                            for (int p2 = k - 1; p2 <= k + 1; p2++) {
                                if (p1 >= 0 && p1 < n && p2 >= 0 && p2 < n) {
                                    max = Math.max(max, dp[i + 1][p1][p2]);
                                }
                            }
                        }
                        res += max;
                    }
                    dp[i][j][k] = res;
                }
            }
        }
        return dp[0][0][n - 1];
    }
}