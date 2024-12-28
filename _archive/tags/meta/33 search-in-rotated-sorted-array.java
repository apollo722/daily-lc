/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

任何一个位置，都会把整个数组分成三段
l ~ mid, mid, mid ~ r
如果tar == nums[mid]，直接返回
否则，根据数组性质，左边和右边一定一段有序一段无序
如果nums[l] <= nums[mid]（有等于是因为l可以等于mid），证明左侧是有序的
此时，如果tar落在左侧，左移右边界，反之右移左边界
如果左侧不是有序的，即右侧是有序的，用一样的逻辑来移动边界即可

Time: O(logn)
Space: O(1)
*/

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int curNum = nums[mid]; 
            if (curNum == target) return mid;
            if (nums[l] <= curNum) {
                if (nums[l] <= target && target < curNum) r = mid - 1;
                else l = mid + 1;
            } else {
                if (curNum < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}