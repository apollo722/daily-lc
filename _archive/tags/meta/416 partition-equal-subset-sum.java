/*
https://leetcode.com/problems/partition-equal-subset-sum/

带memo的dp
先计算sum，如果sum不是偶数，直接返回false
题目等于找到元素使得元素和等于sum/2
每个元素要么被选中，要么没有被选中，在选择的过程中存储扫描到的位置以及此时的和
之后每个元素检查带与不带它

Time: O(mn)，m为sum(nums)/2
Space: O(mn)
*/

class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length, tar = 0;
        for (int num : nums) tar += num;
        if (tar % 2 != 0) return false;
        tar /= 2;
        memo = new Boolean[n + 1][tar + 1];
        return check(nums, 0, tar);
    }

    private boolean check(int[] nums, int idx, int tar) {
        if (idx == nums.length) return tar == 0;
        if (tar < 0) return false;
        if (memo[idx][tar] != null) return memo[idx][tar];
        if (tar == 0) {
            memo[idx][tar] = true;
            return true;
        }
        boolean res = false;
        res = check(nums, idx + 1, tar - nums[idx]) || check(nums, idx + 1, tar);
        return memo[idx][tar] = res;
    }
}