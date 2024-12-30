class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int curDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                while (l < r && l > i + 1 && nums[l] == nums[l - 1]) l++;
                while (l < r && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                if (l >= r) break;
                int sum = nums[i] + nums[l] + nums[r];
                int diff = sum - target;
                if (diff == 0) return target;
                if (Math.abs(diff) < Math.abs(curDiff)) curDiff = diff;
                if (sum > target) r--;
                else l++;
            }
        }
        return target + curDiff;
    }
}