/*
https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/

sliding window模板
0的个数超过1就缩小左边界
注意最后的长度是不带0的，所以要-1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length, l = 0, r = 0, cnt = 0, res = 0;
        while (r < n) {
            cnt += nums[r] == 0 ? 1 : 0;
            if (cnt > 1) {
                cnt -= nums[l++] == 0 ? 1 : 0;
            }
            res = Math.max(res, r - l);
            r++;
        }
        return res;
    }
}