/*
https://leetcode.com/problems/max-consecutive-ones-iii/

优化sliding window模板
如果是1，就一直移动右边界，如果是0，就减少k
如果k小于0了，证明换无可换了，再移动左边界缩小窗口
左边界移动的过程中把转换过的0再加回给k
最后窗口会保持在最长的位置，即r-l

Time: O(n)
Space: O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[r] == 0) k--;
            if (k < 0) {
                if (nums[l++] == 0) k++;
            }
            r++;
        }
        return r - l;
    }
}