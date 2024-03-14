/*
https://leetcode.com/problems/binary-subarrays-with-sum/

与992一样的思路，既然求exact goal不好求，那么转化成传统sliding window
先求小于等于goal的，再求小于等于goal-1（即小于goal）的，二者相减即为等于goal的
这里有点区别的是滑动窗口时左边界可以最多到r处
即要考虑l==r的情况，是只有一个元素的窗口
只有一个元素的时候也有可能直接不满足情况，比如全是0且goal是-1

Time: O(n)
Space: O(n)
*/

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return calc(nums, goal) - calc(nums, goal - 1);
    }

    private int calc(int[] nums, int goal) {
        int l = 0, r = 0, cur = 0, res = 0;
        while (r < nums.length) {
            cur += nums[r];
            while (l <= r && cur > goal) {
                cur -= nums[l++];
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}