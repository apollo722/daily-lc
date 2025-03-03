class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int l = 0, r = n - 1;
        for (int cur : nums) {
            if (cur < pivot) res[l++] = cur;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > pivot) res[r--] = nums[i];
        }
        for (int i = l; i <= r; i++) res[i] = pivot;
        return res;
    }
}