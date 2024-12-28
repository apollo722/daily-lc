/*
https://leetcode.com/problems/move-zeroes/

逐个元素扫描，如果遇到非零元素就移动到位置ptr，并后移ptr

Time: O(n)
Space: O(1)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, cur = 0, i = 0;
        while (i < n) {
            if (nums[i] != 0) {
                swap(nums, i, cur);
                cur++;
            }
            i++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}