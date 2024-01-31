/*
https://leetcode.com/problems/minimum-size-subarray-sum/

sliding window稍微变化，将判断放到满足条件的循环内即可

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int r = 0, l = 0, n = nums.length, res = Integer.MAX_VALUE, curSum = 0;
        while (r < n) {
            curSum += nums[r];
            while (curSum >= target) {
                res = Math.min(res, r - l + 1);
                curSum -= nums[l++];
            }
            r++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}