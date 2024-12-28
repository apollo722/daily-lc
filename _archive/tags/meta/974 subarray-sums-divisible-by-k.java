/*
https://leetcode.com/problems/subarray-sums-divisible-by-k/

标准的subarray找值模板
唯一需要注意的是map里面存的余数是 (k + (curSum % k)) % k
这是由于java中负数对k的余数还是负数，正数对负数取余的余数还是正数
即-3%5=-3，3%-5=3，所以要通过计算给它拨回为正

Time: O(n)
Space: O(n)
*/

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int res = 0, curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum % k == 0) res++;
            int key = (k + (curSum % k)) % k;
            if (m.containsKey(key)) res += m.get(key);
            m.put(key, m.getOrDefault(key, 0) + 1);
            
        }
        return res;
    }
}