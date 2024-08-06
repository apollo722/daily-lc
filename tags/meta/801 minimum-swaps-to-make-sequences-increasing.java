/*
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

只能同idx交换，即i和i换
那么每一个位置只有两种选择，换或者不换
那么前一个位置也只有两种选择，即换了，或者没换
所以总共每个位置根据前一状态总共有四种选择，即前换现换，前不换现不换，前换现不换，前不换现换

先看此刻不换，那么前一个状态如果也没换，即各自已经有序，那么不换=min(不换, 之前不换)
如果是跟对方的前位置有序，即之前换了，那么不换=min(不换，之前换)
对于此刻换也是一样的，只是要+1，因为换了多一步

Time: O(n)
Space: O(1)
*/

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int changed = 1, unchanged = 0;
        for (int i = 1; i < nums1.length; i++) {
            int changedPrev = changed, unchangedPrev = unchanged;
            changed = Integer.MAX_VALUE;
            unchanged = Integer.MAX_VALUE;
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                unchanged = Math.min(unchanged, unchangedPrev);
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                unchanged = Math.min(unchanged, changedPrev);
            }
            if (nums2[i - 1] < nums1[i] && nums1[i - 1] < nums2[i]) {
                changed = Math.min(changed, unchangedPrev + 1);
            }
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                changed = Math.min(changed, changedPrev + 1);
            }
        }
        return Math.min(changed, unchanged);
    }
}