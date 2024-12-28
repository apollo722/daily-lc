/*
https://leetcode.com/problems/range-sum-query-immutable/

presum计算模板

Time: O(n)
Space: O(n)
*/

class NumArray {
    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}