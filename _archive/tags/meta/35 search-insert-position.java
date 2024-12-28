/*
https://leetcode.com/problems/search-insert-position/

二分查找模板

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) l = mid + 1;
            else {
                res = mid;
                r = mid - 1;
            }
        }
        return res == -1 ? nums.length : res;
    }
}