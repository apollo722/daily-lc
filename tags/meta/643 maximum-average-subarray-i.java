/*
https://leetcode.com/problems/maximum-average-subarray-i/

先求出整体和，之后滑动的找到最大的subarr和

Time: O(n)
Space: O(1)
*/

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }
}