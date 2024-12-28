/*
https://leetcode.com/problems/paint-fence/

dp模板，假设dp[i]为截止到i时总共可能的情况
对于第i块板，可以和前一块版涂相同的颜色，也可以涂不同的颜色
如果涂不同的颜色，总共有k-1中选择，那么当前结果即为(k-1)*dp[i-1]
如果涂相同的颜色，有一个限制，即不能和i-2处一样，也意味着i-1处不和i-2处不一样
i-1处不和i-2处一样还是只有k-1中选择，那么即dp[i-2]*(k-1)，也就是i处不和i-2处不一样的结果

当前状态只取决于前1和2个状态，所以可以进一步优化成常数空间复杂度

Time: O(n)
Space: O(n)
*/

class Solution {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;
        int[] dp = new int[n + 1];
        dp[1] = k;
        dp[2] = k * k;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
        }
        return dp[n];
    }
}