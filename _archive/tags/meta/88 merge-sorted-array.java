/*
https://leetcode.com/problems/merge-sorted-array/

从最右端开始merge即可

Time: O(m)
Space: O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int cur = nums1.length - 1;
        while (m >= 0 || n >= 0) {
            int d1 = m >= 0 ? nums1[m] : Integer.MIN_VALUE;
            int d2 = n >= 0 ? nums2[n] : Integer.MIN_VALUE;
            if (d1 < d2) {
                nums1[cur--] = d2;
                n--;
            } else {
                nums1[cur--] = d1;
                m--;
            }
        }
    }
}