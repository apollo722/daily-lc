/*
https://leetcode.com/problems/house-robber-ii/

与198如出一辙，头尾不能同时取，那就做两次，一次从0到n-1，一次从1到n即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int res = 0, dp1 = nums[0], dp2 = Math.max(dp1, nums[1]);
        for (int i = 2; i < n - 1; i++) {
            int cur = Math.max(dp2, dp1 + nums[i]);
            dp1 = dp2;
            dp2 = cur;
        }
        res = Math.max(dp1, dp2);
        dp1 = nums[1];
        dp2 = Math.max(dp1, nums[2]);
        for (int i = 3; i < n; i++) {
            int cur = Math.max(dp2, dp1 + nums[i]);
            dp1 = dp2;
            dp2 = cur;
        }
        return Math.max(res, Math.max(dp1, dp2));
    }
}