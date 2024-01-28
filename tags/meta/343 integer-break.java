/*
https://leetcode.com/problems/integer-break/

n小于等于3的时候，直接返回n-1
大于3的时候利用dp扫描所有从1到num/2+1的数，取最大值即可

本题也可以利用数学以O(n)甚至O(logn)时间且常数空间求解：https://leetcode.com/problems/integer-break/editorial/

Time: O(n)
Space: O(n)
*/

class Solution {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        
        for (int i = 4; i <= n; i++) {
            for (int num = 1; num < i / 2 + 1; num++)
                dp[i] = Math.max(dp[i], num * dp[i - num]);
        }
        return dp[n];
    }
}