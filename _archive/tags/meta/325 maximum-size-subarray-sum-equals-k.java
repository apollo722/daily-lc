/*
https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

subarray sum模板
细微变种是题目要求找最长的子集，所以只有当map中不含有curSum的时候才要更新map
这样可以保留最靠前的curSum的位置以寻求最长子集

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int curSum = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            curSum += cur;
            if (curSum == k) res = Math.max(res, i + 1);
            if (m.containsKey(curSum - k)) {
                res = Math.max(res, i - m.get(curSum - k));
            } else if (!m.containsKey(curSum)) m.put(curSum, i);
        }
        return res;
    }
}