/*
https://leetcode.com/problems/first-bad-version/

二分查找模板

Time: O(logn)
Space: O(1)
*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 1, r = n, res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) {
                res = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return res;
    }
}