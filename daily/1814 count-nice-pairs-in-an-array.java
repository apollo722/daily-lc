/*
https://leetcode.com/problems/count-nice-pairs-in-an-array/

遇到类似问题，可以先行将下表相同的项转移到等号同侧
Ai + rev(Bj) == Bj + rev(Ai) -> Ai - rev(Ai) == Bj - rev(Bj)

转移后变成two sum问题

Time: O(nlogm)，reverse num需要logm，m为nums的平均位数
Space: O(n)
*/

class Solution {
    public int countNicePairs(int[] nums) {
        int mod = (int)(1e9 + 7);
        int res = 0;
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = nums[i] - calc(nums[i]);
            if (m.containsKey(diff)) res = (res + m.get(diff)) % mod;
            m.put(diff, (m.getOrDefault(diff, 0) + 1));
        }
        return (int)(res % mod);
    }

    public int calc(int num){
        int res = 0;
        while(num != 0){
            int digit = num % 10;
            res = res * 10 + digit;
            num /= 10;
        }
        return res;
    }
}