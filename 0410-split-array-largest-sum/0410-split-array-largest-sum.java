class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        for (int num : nums) r += num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = countGroup(nums, mid, k);
            if (cur > k) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }

    private int countGroup(int[] nums, int sum, int k) {
        int curSum = 0, res = 1;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > sum) {
                res++;
                curSum = 0;
                i--;
            }
            if (res > k) return k + 1;
        }
        return res;
    }
}