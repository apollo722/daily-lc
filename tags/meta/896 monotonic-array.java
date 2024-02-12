/*
https://leetcode.com/problems/monotonic-array/

检查每一对相邻的元素，记录递增还是递减
如果检测到递增，但已经标记为递减，直接返回false
反之亦然

Time: O(n)
Space: O(1)
*/

class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean increase = false, decrease = false;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                if (decrease) return false;
                increase = true;
            } else if (nums[i] < nums[i - 1]) {
                if (increase) return false;
                decrease = true;
            }
        }
        return true;
    }
}