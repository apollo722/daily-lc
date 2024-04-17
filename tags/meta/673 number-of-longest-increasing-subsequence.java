/*
https://leetcode.com/problems/number-of-longest-increasing-subsequence/

dp模板
扫描每一个元素，以及其与之前所有元素的关系
如果找到了更大的，就记录上截止到当前元素最长的序列的长度，并将个数重置为0
之后更新长度个数，如果此时截止到当前元素的长度恰好是之前的某个元素长度+1，证明之前的那个元素的count数可以加到当前元素的count数上
意为所有以之前元素为结尾的序列都可以以新的当前元素为结尾
最后扫描一遍所有的长度，找到最长的，再统计有多少个最长的即可

Time: O(n^2)
Space: O(n)
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int curMax = 0, curCount = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = 0;
                    }
                    if (dp[i] == dp[j] + 1) count[i] += count[j];
                }             
            }
        }
        for (int len : dp) curMax = Math.max(curMax, len);
        for (int i = 0; i < n; i++) {
            if (dp[i] == curMax) curCount += count[i];
        }
        return curCount;
    }
}