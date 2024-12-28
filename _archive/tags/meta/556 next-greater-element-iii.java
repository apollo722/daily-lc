/*
https://leetcode.com/problems/next-greater-element-iii/

与 31 https://leetcode.com/problems/next-permutation/ 一样
只是注意判断特殊情况，即超过Integer.MAX_INT的情况即可

Time: O(n)
Space: O(n)
*/

class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = new String(n + "").toCharArray();
        int len = nums.length, idx = -1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) return -1;
        int largerIdx = len - 1;
        while (largerIdx > idx && nums[largerIdx] <= nums[idx]) largerIdx--;
        swap(nums, idx, largerIdx);
        reverse(nums, idx + 1, len - 1);
        if (Long.valueOf(new String(nums)) > Integer.MAX_VALUE) return -1;
        return Integer.valueOf(new String(nums));
    }

    private void swap(char[] nums, int a, int b) {
        char c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }

    private void reverse(char[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}