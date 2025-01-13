class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return mid;
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target <= nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}


/*
二分查找，每次找到的位置会把数组分成两部分，其中一定有一部分是有序的。
只要看最左边和找到的位置是不是小于关系即可，如果小于，证明左边是有序的，否则右边是有序的。
如果target落在有序的一边，那么只需要把下标向那边移动即可。因为二分查找只能在有序的一侧起作用。
如果不在有序的那边，就把下标移动到另一侧，直到缩小范围到有序的一段。
因为l是可以等于mid的，所以对于有序窗口的判断要nums[l]<=nums[mid]，带上等号。
*/