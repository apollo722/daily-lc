/*
https://leetcode.com/problems/perfect-squares/

dp模板
每一个数字都看一下所有小于它的完全平方数加点什么能不能组成它
找其中最小的即可

Time: O(n sqrt(n))
Space: O(n)
*/

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}