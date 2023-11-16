/*
https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/

排序之后从两端向内找即可

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while (l < r) {
            res = Math.max(res, nums[l++] + nums[r--]);
        }
        return res;
    }
}