/*
https://leetcode.com/problems/partition-array-for-maximum-sum/

用top down dp来求解每一个位置，假设dp[i]为到i位置的max sum
对于任意一个位置i，测试所有i到边界或i-k内所有可能的组合，找到最大的sum
当前subarr的sum即为长度*max，加上余下的数组的结果
利用dp存储每个位置求出来的结果加速计算

Time: O(nk)
Space: O(n)
*/

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return calc(arr, dp, n - 1, k);
    }

    private int calc(int[] arr, int[] dp, int idx, int k) {
        int n = arr.length;
        if (idx == -1) return 0;
        if (dp[idx] != -1) return dp[idx];
        int curMax = 0, res = 0, start = Math.max(-1, idx - k);
        for (int i = idx; i > start; i--) {
            curMax = Math.max(arr[i], curMax);
            res = Math.max(res, curMax * (idx - i + 1) + calc(arr, dp, i - 1, k));
        }
        dp[idx] = res;
        return res;
    }
}