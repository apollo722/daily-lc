/*
https://leetcode.com/problems/climbing-stairs/

当前状态等于一步前与两步前状态之和

Time: O(n)
Space: O(1)
*/

class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 0, dp2 = 1, dp1 = 2;
        for (int i = 3; i <= n; i++) {
            res = dp2 + dp1;
            dp2 = dp1;
            dp1 = res;
        }
        return res;
    }
}