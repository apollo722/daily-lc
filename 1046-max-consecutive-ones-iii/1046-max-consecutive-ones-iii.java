class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0;
        while (r < n) {
            int cur = nums[r];
            if (cur == 0) k--;
            if (k < 0) {
                int left = nums[l];
                l++;
                if (left == 0) k++;
            }
            r++;
        }
        return r - l;
    }
}