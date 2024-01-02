/*
https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/

sliding window模板，只需要追踪个数和频率这两个指标即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0, curSum = 0;
        int cnt = 0, n = nums.length, l = 0, r = 0;
        int[] m = new int[100001];
        while (r < n) {
            int cur = nums[r];
            m[cur]++;
            cnt++;
            curSum += cur;
            while (m[cur] > 1 || cnt > k) {
                int left = nums[l];
                m[left]--;
                curSum -= left;
                cnt--;
                l++;
            }
            if (cnt == k) res = Math.max(res, curSum);
            r++;
        } 
        return res;
    }
}