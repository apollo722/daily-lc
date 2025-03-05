class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, res = Integer.MIN_VALUE;
        for (int num : nums) {
            curSum = Math.max(num, curSum + num);
            res = Math.max(res, curSum);
        }
        return res;
    }
}