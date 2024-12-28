/*
https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

本质上是backtrack+memo的问题
首先看数组总和是否能被k整除
之后为了优化速度，把数组排序，并从反向开始处理
从反向处理的好处是某些case能更快的剪枝，因为每个元素必然属于某一个subset
所以如果在任一时刻如果一个subset没有加入任何新的元素，那么结果必然不平衡，直接返回false
遍历所有subset，之后把加入进去不会导致超过target的元素加入subset，之后继续backtrack
如果加入的元素没有导致true，证明这个元素不属于这个subset，那么重置，并继续看是不是属于下一个subset

Time: O(k^n)
Space: O(n)
*/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % k != 0 || k > nums.length) return false;
        Arrays.sort(nums);
        return backtrack(nums, sum / k, nums.length - 1, new int[k]);
    }

    private boolean backtrack(int[] nums, int tar, int idx, int[] subset) {
        if (idx == -1) return true;
        for (int i = 0; i < subset.length; i++) {
            if (nums[idx] + subset[i] <= tar) {
                subset[i] += nums[idx];
                if (backtrack(nums, tar, idx - 1, subset)) return true;
                subset[i] -= nums[idx];
            }
            if (subset[i] == 0) break;
        }
        return false;
    }
}