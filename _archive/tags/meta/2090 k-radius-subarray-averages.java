/*
https://leetcode.com/problems/k-radius-subarray-averages/

sliding window的模式，移动一格操作一次边界即可
需要先把第一个2*k+1窗口内的和求出来，并注意sum的越界，需要用long

Time: O(n)
Space: O(1)
*/

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        if (2 * k + 1 > n) return res;
        if (k == 0) return nums;
        long sum = 0, avgLen = 2 * k + 1;
        for (int i = 0; i < 2 * k + 1; i++) sum += nums[i];
        for (int i = k; i < n; i++) {
            if (i - k < 0 || i + k >= n) continue;
            res[i] = (int) (sum / avgLen);
            if (i + k + 1 < n) {
                sum -= nums[i - k];
                sum += nums[i + k + 1];
            }
        }
        return res;
    }
}