/*
https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/

用dp来记录浇水到i位置需要的最小tab数
每到一个位置可以算出当前位置cover的范围
那么在范围里的所有位置都可以覆盖到当前位置的最远处，所以就可以循环位置以求的当前最远处的最小tab数
有greedy的O(n)解法：https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/editorial/

Time: O(mn)，m为average range
Space: O(n)
*/

class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int start = Math.max(0, i - ranges[i]), end = Math.min(n, i + ranges[i]);
            for (int j = start; j <= end; j++) {
                dp[end] = Math.min(dp[end], dp[j] + 1);
            }
        }
        if (dp[n] == Integer.MAX_VALUE - 1) return -1;
        return dp[n];
    }
}