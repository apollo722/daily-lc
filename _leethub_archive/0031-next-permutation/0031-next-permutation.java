class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, idx = -1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                idx = i - 1;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        int r = n - 1;
        while (r > idx && nums[r] <= nums[idx]) {
            r--;
        }
        swap(nums, idx, r);
        reverse(nums, idx + 1, n - 1);
    }

    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}