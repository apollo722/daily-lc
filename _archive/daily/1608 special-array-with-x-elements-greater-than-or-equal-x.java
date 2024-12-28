/*
https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/

二分查找模板
也可以用count sort + preSum来O(n) + O(n)解决

Time: O(nlogn)
Space: O(1)
*/

class Solution {
    public int specialArray(int[] nums) {
        int l = 0, r = 1000;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = check(nums, mid);
            if (cnt > mid) l = mid + 1;
            else if (cnt < mid) r = mid - 1;
            else return mid;
        }
        return -1;
    }

    private int check(int[] nums, int tar) {
        int res = 0;
        for (int num : nums) {
            if (num >= tar) res++;
        }
        return res;
    }
}