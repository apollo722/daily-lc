/*
https://leetcode.com/problems/longest-continuous-increasing-subsequence/

逐对检查，track最长的序列
如果遇到非递增，重置counter

Time: O(n)
Space: O(1)
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length, cnt = 1, res = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                cnt = 1;
            }
        }
        return res;
    }
}