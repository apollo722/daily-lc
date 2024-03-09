/*
https://leetcode.com/problems/minimum-common-value/

two ptr逐个比较

Time: O(max(m,n))
Space: O(1)
*/

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int l = 0, r = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] == nums2[r]) return nums2[r];
            else if (nums1[l] < nums2[r]) l++;
            else r++;
        }
        return -1;
    }
}