/*
https://leetcode.com/problems/find-pivot-index/

计算preSum，之后每个位置都可以计算左边和右边的和
找到相等的位置即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) preSum[i] = nums[i] + preSum[i - 1];
        for (int i = 0; i < n; i++) {
            int left = preSum[i] - nums[i];
            int right = preSum[n - 1] - preSum[i];
            if (left == right) return i;
        }
        return -1;
    }
}