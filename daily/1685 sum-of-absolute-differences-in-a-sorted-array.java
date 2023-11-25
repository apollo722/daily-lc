/*
https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/

因为数组是排序过的，所以每次只要知道左边的和与右边的和即可
所以利用preSum数组可以求解
但也可以即时计算preSum，右侧和可以通过totalSum来计算，省下空间

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        int[] res = new int[n];
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            int cntl = i, cntr = n - i - 1;
            int sumLeft = i > 0 ? curSum : 0, sumRight = totalSum - curSum - nums[i];
            curSum += nums[i];
            res[i] = cntl * nums[i] - sumLeft + sumRight - cntr * nums[i];
        }
        return res;
    }
}