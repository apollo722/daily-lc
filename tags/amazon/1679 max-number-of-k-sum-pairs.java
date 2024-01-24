/*
https://leetcode.com/problems/max-number-of-k-sum-pairs/

two sum模板问题
记录k-num出现的个数，如果大于0，即可以组成pair，个数-1
否则存上num

Time: O(n)
Space: O(n)
*/

class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int cur = m.getOrDefault(k - num, 0);
            if (cur > 0) {
                res++;
                m.put(k - num, cur - 1);
            } else m.put(num, m.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}