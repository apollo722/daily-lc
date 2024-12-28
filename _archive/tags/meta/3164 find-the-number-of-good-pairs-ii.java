/*
https://leetcode.com/problems/find-the-number-of-good-pairs-ii/

先找到nums2的基础因数，即nums2 * k，在此基础上，每次增加一个nums2 * k，直到到nums1中的最大值为止
为了去重，可以先统计频率
将所有可能出现的因数个数都存起来，最后根据nums1中的值来加总

Time: O(?)
Space: O(max(nums1) + n2)
*/

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int max = nums1[0];
        for (int num : nums1) {
            max = Math.max(max, num);
        }
        for (int num : nums2) {
            m.put(num * k, m.getOrDefault(num * k, 0) + 1);
        }
        long[] resCounter = new long[max + 1];
        for (int key : m.keySet()) {
            int cnt = m.get(key);
            for (int i = key; i <= max; i += key) {
                resCounter[i] += cnt;
            }
        }
        long res = 0;
        for (int num : nums1) {
            res += resCounter[num];
        }
        return res;
    }
}