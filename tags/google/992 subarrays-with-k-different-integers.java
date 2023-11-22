/*
https://leetcode.com/problems/subarrays-with-k-different-integers/

遇到计数k的先想到sliding window
这里想找的是exact k，可以转化成 (小于等于k) - (小于等于k-1) 的差
同样的想法可以应用到所有找范围的题，比如l <= x <= r，转化成 (小于r+1) - (小于l)
剩下的用sliding window即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    private int count(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int n = nums.length, l = 0, r = 0, res = 0;
        while (r < n) {
            int cur = nums[r];
            m.put(cur, m.getOrDefault(cur, 0) + 1);
            while (m.size() > k) {
                int prev = nums[l];
                m.put(prev, m.get(prev) - 1);
                if (m.get(prev) == 0) m.remove(prev);
                l++;
            }
            res += r - l + 1;
            r++;
        }
        return res;
    }
}