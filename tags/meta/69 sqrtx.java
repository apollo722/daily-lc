/*
https://leetcode.com/problems/sqrtx/

二分查找模板，注意edge case x=2时要返回1

Time: O(logm)
Space: O(1)
*/

class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;
        int l = 2, r = x / 2, res = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sqrt = x / mid;
            if (sqrt <= mid) {
                r = mid - 1;
                res = sqrt;
            } else l = mid + 1;
        }
        return res;
    }
}