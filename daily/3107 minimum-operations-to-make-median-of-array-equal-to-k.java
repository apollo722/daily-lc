/*
https://leetcode.com/problems/minimum-operations-to-make-median-of-array-equal-to-k/

排序后，前半段都应该比k小，后半段都应该比k大（注意题目的median定义是中间值的较大者，不是平均值）
所以排序后，如果中间的那个数小于或等于k，证明右边有可能有比k更大的，左边就都是比k小的了
所以扫描右边把比k小的差加到结果即可
反之亦然

Time: O(nlogn)
Space: O(logn)
*/

class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        int n = nums.length, x = nums[n / 2];
        if (x <= k) {
            for (int i = n / 2; i < n; i++) {
                if (k < nums[i]) break;
                res += k - nums[i];
            }
        } else {
            for (int i = n / 2; i >= 0; i--) {
                if (nums[i] < k) break;
                res += nums[i] - k;
            }
        }
        return res;
    }
}