/*
https://leetcode.com/problems/find-peak-element/

二分查找
有个条件为数组相邻元素不同
首先l < r而不是l <= r，保证mid check不会越右界，因为如此l和r至少相邻，且mid为l
当nums[mid] < nums[mid + 1]时，证明处于递增段，那么应该向右查找因为右侧数字更大，更可能为结果
如果反之，那么当前mid可能为结果，也可能处于递减段而不是，总之是要向左查找，那么r = mid
最后退出返回时l与r已经相等了，返回哪个都行

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[mid + 1]) l = mid + 1;
            else {
                r = mid;
            }
        }
        return r;
    }
}