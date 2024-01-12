/*
https://leetcode.com/problems/cutting-ribbons/

利用二分查找找到满足条件的长度

Time: O(nlog(max(ribbons)))
Space: O(1)
*/

class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1, r = 0, res = 0;
        for (int num : ribbons) if (r < num) r = num;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = calc(ribbons, mid);
            if (cnt < k) r = mid - 1;
            else {
                res = mid;
                l = mid + 1;
            }
        }
        return res;
    }

    private int calc(int[] arr, int len) {
        int res = 0;
        for (int num : arr) res += num / len;
        return res;
    }
}