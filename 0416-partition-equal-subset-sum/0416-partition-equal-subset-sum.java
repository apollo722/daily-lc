class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int total = 0, n = nums.length;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;
        int target = total / 2;
        memo = new Boolean[n + 1][target + 1];
        return check(nums, 0, target);
    }

    private boolean check(int[] nums, int idx, int target) {
        if (idx == nums.length) return target == 0;
        if (target < 0) return false;
        if (memo[idx][target] != null) return memo[idx][target];
        if (target == 0) {
            memo[idx][target] = true;
            return true;
        }
        boolean res = false;
        res = check(nums, idx + 1, target - nums[idx]) || check(nums, idx + 1, target);
        return memo[idx][target] = res;
    }
}