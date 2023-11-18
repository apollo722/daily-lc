/*
https://leetcode.com/problems/reduction-operations-to-make-the-array-elements-equal/

排序后，等同于求解每个数字所在的位置，距离一个最小值的最小距离
因为每一个数字都至少要跨过其和最小值之间的每一个数字以达到最小

Time: O(nlogn)
Space: O(1) （不考虑排序所需要的空间）
*/

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int res = 0, cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                cur++;
            }
            res += cur;
        }
        return res;
    }
}