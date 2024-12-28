/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

二分查找模板，注意边界写法

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int leftBound = findLeft(nums, target, l, r);
        if (leftBound == -1) return new int[]{-1, -1};
        int rightBound = findRight(nums, target, l, r);
        return new int[]{leftBound, rightBound};
    }

    private int findLeft(int[] nums, int tar, int l, int r) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < tar) l = mid + 1;
            else if (nums[mid] > tar) r = mid - 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res;
    }
    private int findRight(int[] nums, int tar, int l, int r) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < tar) l = mid + 1;
            else if (nums[mid] > tar) r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }
}