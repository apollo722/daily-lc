/*
https://leetcode.com/problems/maximum-subarray/

Kadane算法
每个元素都可以作为数组的起点，如果以此作为起点要比以之前元素作为起点和更大的话

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, curSum = 0;
        for (int num : nums) {
            curSum = Math.max(num, curSum + num);
            res = Math.max(res, curSum);
        }
        return res;
    }
}