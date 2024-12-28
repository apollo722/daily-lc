/*
https://leetcode.com/problems/edit-distance/

标准dp，注意初始化的时候要先把第一行和第一列根据情况置成各自对应位置的长度
如果某一位置s==t，那么当前状态就等于(i-1, j-1)的状态
否则，当前状态就是(i-1, j)，(i, j-1)，(i-1, j-1)中最小值+1

Time: O(mn)
Space: O(mn)
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (n == 0) return m;
        if (m == 0) return n;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) dp[i][0] = i;
        for (int i = 1; i <= n; i++) dp[0][i] = i;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char s = word1.charAt(i - 1), t = word2.charAt(j - 1);
                if (s == t) dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}