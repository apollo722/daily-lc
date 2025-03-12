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