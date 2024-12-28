/*
https://leetcode.com/problems/unique-paths/

压缩成一维的dp模板

Time: O(mn)
Space: O(n)
*/

class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) return 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            int[] tmp = dp.clone();
            for (int j = 1; j < n; j++) {
                tmp[j] = tmp[j - 1] + dp[j];
            }
            dp = tmp;
        }
        return dp[n - 1];
    }   
}