/*
https://leetcode.com/problems/continuous-subarray-sum/

用hashmap存所有curSum对k的余数对应的下标
如果curSum % k曾经出现过
那么证明出现过的下标和当前下标之间数字和即为所求

Time: O(n)
Space: O(min(k, n))，最多也就有k个余数
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        HashMap<Integer, Integer> m = new HashMap<>();
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            if (i > 0 && curSum % k == 0) return true;
            if (!m.containsKey(curSum % k)) m.put(curSum % k, i);
            else {
                if (i - m.get(curSum % k) >= 2) return true;
            }
        }
        return false;
    }
}