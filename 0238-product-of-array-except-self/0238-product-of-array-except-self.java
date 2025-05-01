class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = nums[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        int curProd = 1;
        int[] res = new int[n];
        for (int i = n - 1; i >= 1; i--) {
            res[i] = curProd * left[i - 1];
            curProd *= nums[i];
        }
        res[0] = curProd;
        return res;
    }
}