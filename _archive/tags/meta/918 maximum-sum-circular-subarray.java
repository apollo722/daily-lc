/*
https://leetcode.com/problems/maximum-sum-circular-subarray/

Kadane算法的变种
如果是普通的找最大的subarr和，那么就是普通Kadane算法
数组变成circular之后，最大的subarr和可能首尾相连
那么如果我们知道数组总和，以及中间一段最小的subarr和，总和减去最小的和，剩下的首尾两端的两段和就是所求的最大和
所以扫描数组的时候同时记录total，maxSum以及minSum
如果最后total和minSum一样，说明整体来说是个负数，那么按照原版Kadane算法返回maxSum就行
否则就要比较首尾段的和以及maxSum的大小

Time: O(n)
Space: O(1)
*/

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length, curMax = 0, curMin = 0, maxSum = nums[0], minSum = nums[0], total = 0;
        for (int i = 0; i < n; i++) {
            total += nums[i];
            curMax = Math.max(nums[i], curMax + nums[i]);
            maxSum = Math.max(curMax, maxSum);
            curMin = Math.min(nums[i], curMin + nums[i]);
            minSum = Math.min(curMin, minSum);
        }
        return minSum == total ? maxSum : Math.max(total - minSum, maxSum);
    }
}