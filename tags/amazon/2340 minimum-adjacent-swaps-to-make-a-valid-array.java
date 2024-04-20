/*
https://leetcode.com/problems/minimum-adjacent-swaps-to-make-a-valid-array/

贪心，先找到第一个最小值的位置和最后一个最大值的位置
分别计算二者距离左右边界的距离
如果最小值在最大值的右侧，说明省下一次交换，最后结果需要再-1

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minimumSwaps(int[] nums) {
        int min = nums[0], max = nums[0], maxIdx = 0, minIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] >= max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int res = minIdx + (nums.length - maxIdx - 1);
        if (minIdx > maxIdx) res--;
        return res;
    }
}