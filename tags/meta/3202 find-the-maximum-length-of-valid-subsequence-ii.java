/*
https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/

参见3201
共有kxk种余数排列，比如k=3，排列有：000，111，222，0101，0202，1212，2121等等
每次遇到一个元素，取余后
它前面为0~k-1的所有组合都+1
找到其中最长的即可

Time: O(nk)
Space: O(kk)
*/

class Solution {
    public int maximumLength(int[] nums, int k) {
        int res = 0;
        int[][] dp = new int[k][k];
        for (int num : nums) {
            for (int i = 0; i < k; i++) {
                dp[i][num % k] = dp[num % k][i] + 1;
                res = Math.max(res, dp[i][num % k]);
            }
        }
        return res;
    }
}