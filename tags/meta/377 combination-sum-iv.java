/*
https://leetcode.com/problems/combination-sum-iv/

标准DP
跟硬币找零差不多，假设dp[i]为能形成值为i的组合数
那么遍历每个元素，能形成i的个数即dp[i] = dp[i - nums[j]]

Time: O(tn)
Space: O(t)
*/

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > i) continue;
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}