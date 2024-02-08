/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

二分查找，对于任何一个位置，如果后面的元素比前面小，那较小的一定是结果
而且如果当前元素比目前窗口最左端大，那么左侧一定是有序的，那么最小值一定在右侧
否则最小值一定在左侧rotate发生的位置
如果最后没找到结果，证明整个数组是有序的，返回最左端元素

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] < nums[mid - 1]) return nums[mid];
            if (nums[mid] > nums[l]) l = mid + 1;
            else r = mid - 1;
        }
        return nums[0];
    }
}