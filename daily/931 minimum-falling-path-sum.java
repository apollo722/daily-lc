/*
https://leetcode.com/problems/minimum-falling-path-sum/

标准动态规划
下一行的状态只取决于上一行的左中右三个位置，取最小加上去即可

Time: O(n^2)
Space: O(n)
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, res = Integer.MAX_VALUE;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = matrix[0][i];
            if (m == 1) res = Math.min(res, dp[i]);
        }
        for (int i = 1; i < m; i++) {
            int[] newDp = new int[n];
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j], top = dp[j];
                int left = j - 1 >= 0 ? dp[j - 1] : top;
                int right = j + 1 < n ? dp[j + 1] : top;
                newDp[j] = cur + Math.min(Math.min(top, left), right);
                if (i == m - 1) res = Math.min(res, newDp[j]);
            }
            dp = newDp;
        }
        return res;
    }
}