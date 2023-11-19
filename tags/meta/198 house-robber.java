/*
https://leetcode.com/problems/house-robber/

dp track前一个和前两个的结果

Time: O(n)
Space: O(1)
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int dp2 = nums[0];
        int dp1 = Math.max(dp2, nums[1]);
        int cur = Integer.MIN_VALUE;
        for (int i = 2; i < n; i++) {
            cur = Math.max(dp1, dp2 + nums[i]);
            dp2 = dp1;
            dp1 = cur;
        }
        return cur;
    }
}