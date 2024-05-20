/*
https://leetcode.com/problems/sum-of-all-subset-xor-totals/

有更快的位运算算法，但不掌握了
所有的subset即每个元素要么在里面，要么不在，所以计算每个元素在结果里即可

Time: O(2^n)
Space: O(n)
*/

class Solution {
    public int subsetXORSum(int[] nums) {
        return calc(nums, 0, 0);
    }

    private int calc(int[] nums, int idx, int cur) {
        if (idx == nums.length) return cur;
        return calc(nums, idx + 1, cur ^ nums[idx]) + calc(nums, idx + 1, cur);
    }
}