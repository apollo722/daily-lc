/*
https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/

sliding window模板

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int l = 0, r = 0, n = nums.length, res = 0;
        while (r < n) {
            m.put(nums[r], m.getOrDefault(nums[r], 0) + 1);
            while (m.get(nums[r]) > k) {
                m.put(nums[l], m.get(nums[l]) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}